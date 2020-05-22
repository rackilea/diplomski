package put.here.your.package;


    import com.badlogic.gdx.Gdx;
    import com.badlogic.gdx.graphics.Texture.TextureFilter;
    import com.badlogic.gdx.graphics.g2d.BitmapFont;
    import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
    import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
    import com.badlogic.gdx.scenes.scene2d.InputEvent;
    import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
    import com.badlogic.gdx.scenes.scene2d.ui.Skin;
    import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
    import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

    public class MyTextButton extends TextButton
    {
        BitmapFont upFont, downFont;
        LabelStyle upStyle, downStyle;
        float upLeftPad, upTopPad, downLeftPad, downTopPad;

        public MyTextButton(String text, Skin skin, String styleName) //you can create more constructors just call in them super then init!
        {
            super(text, skin, styleName);

            init();
        }

        private void init()
        {   
            //see the comments near the method below
            this.createFonts();

            //this is important! it will cleared effect of skin up/down settings what is good for me but should not be for you - then remove the following line
            this.clearListeners();

            //creating styles basing on current style and fonts we have generated
            upStyle = new LabelStyle( this.getLabel().getStyle() );
            upStyle.font = upFont;

            downStyle = new LabelStyle( this.getLabel().getStyle() );
            downStyle.font = downFont;

            //setting upStyle for a start - on a start the button is not pushed
            this.getLabel().setStyle(upStyle);

            //setting the listener that will change the style due to is button clicked or not right now - see its definition on the bottom of class
            this.addListener(clickListener);

            //this is calculating current 
            this.upLeftPad = getLabelCell().getPadLeft();
            this.upTopPad = getLabelCell().getPadTop();

            this.downLeftPad = getLabelCell().getPadLeft() + 4; //the value (4) should be changed if you will change shadowOffset of fonts
            this.downTopPad = getLabelCell().getPadTop() + 4; //because we want to make shadow small and move label which make us an illusion of pushing font

            //here one note! the funny thing is that imho above value should be shadowOffsetY of upFont - shadowOffsetY of downFont
            //but it is not actually - I mean it is not ok, right bottom corner is not at the same position which is weird so just choose your value
        }

        //this method create two fonts - up version and pushed version - the pushed version should have smaller shadow
        private void createFonts()
        {
            //firstly we need a generator (integrated with LibGDX) to generate from .ttf file - so you will need .ttf!
            FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("font.ttf")); //path to yout .ttf file
            FreeTypeFontParameter parameter = new FreeTypeFontParameter();

            parameter.size = 42;

            parameter.magFilter = TextureFilter.Linear; //it will make
            parameter.minFilter = TextureFilter.Linear; //the font render better

            //generating font for nonclicked (up) button version
            parameter.shadowOffsetX = 6; //defining of 
            parameter.shadowOffsetY = 6; //shadow offset ~= size

            upFont = generator.generateFont(parameter);

            //generating font for nonclicked (up) button version
            parameter.shadowOffsetX = 3; //as above
            parameter.shadowOffsetY = 3; //it should be smaller!

            downFont = generator.generateFont(parameter);

            //fonts are generated

            generator.dispose();
        }

        //setting style and label offset for pushed button
        private void setDown()
        {
            getLabel().setStyle(downStyle);

            getLabelCell().padTop( downTopPad );
            getLabelCell().padLeft( downLeftPad );
        }

        //setting style and label offset for non pushed button
        private void setUp()
        {
            getLabel().setStyle(upStyle);

            getLabelCell().padTop( upTopPad );
            getLabelCell().padLeft( upLeftPad );
        }

        //the listener that will change style due to what action is actually being performed on the button
        ClickListener clickListener = new ClickListener() 
        {
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button)
            {
                setDown();
                return true;
            }

            @Override
            public void touchDragged (InputEvent event, float x, float y, int pointer)
            {
                setUp();
            }

            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button)
            {
                setUp();
            }
        };

    }