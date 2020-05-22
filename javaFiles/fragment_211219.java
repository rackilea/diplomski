private SpriteBatch spriteBatch;
private FrameBuffer frmBuff;
private TextureRegion frm;
private OrthographicCamera frmCam;
private FrameBuffer maskBuff;
private TextureRegion msk;

int frmSizeX = 500;
int frmSizeY = 700;

private ShapeRenderer renderer;

private ShaderProgram shader;

public static final int MASK_OFFSET_X = 55 - (int) Constants.BACKGROUND_OFFSET_X - 8;
public static final int MASK_OFFSET_Y = 150;

Texture tex0;
Texture mask;
SpriteBatch myBatch;

final String VERT =  
        "attribute vec4 "+ShaderProgram.POSITION_ATTRIBUTE+";\n" +
        "attribute vec4 "+ShaderProgram.COLOR_ATTRIBUTE+";\n" +
        "attribute vec2 "+ShaderProgram.TEXCOORD_ATTRIBUTE+"0;\n" +

        "uniform mat4 u_projTrans;\n" + 
        " \n" + 
        "varying vec4 vColor;\n" +
        "varying vec2 vTexCoord;\n" +

        "void main() {\n" +  
        "   vColor = "+ShaderProgram.COLOR_ATTRIBUTE+";\n" +
        "   vTexCoord = "+ShaderProgram.TEXCOORD_ATTRIBUTE+"0;\n" +
        "   gl_Position =  u_projTrans * " + ShaderProgram.POSITION_ATTRIBUTE + ";\n" +
        "}";

final String FRAG = 
        //GL ES specific stuff
          "#ifdef GL_ES\n" //
        + "#define LOWP lowp\n" //
        + "precision mediump float;\n" //
        + "#else\n" //
        + "#define LOWP \n" //
        + "#endif\n" + //
        "varying LOWP vec4 vColor;\n" +
        "varying vec2 vTexCoord;\n" + 
        "uniform sampler2D u_texture;\n" +  
        "uniform sampler2D u_texture1;\n" +
        "uniform sampler2D u_mask;\n" + 
        "void main(void) {\n" + 
        "   //sample the colour from the first texture\n" + 
        "   vec4 texColor0 = texture2D(u_texture, vTexCoord);\n" + 
        "\n" + 
        "   //sample the colour from the second texture\n" + 
        "   vec4 texColor1 = texture2D(u_texture1, vTexCoord);\n" + 
        "\n" + 
        "   //get the mask; we will only use the alpha channel\n" + 
        "   float mask = texture2D(u_mask, vTexCoord).a;\n" + 
        "\n" + 
        "   //interpolate the colours based on the mask\n" + 
        "   gl_FragColor = vColor * mix(texColor0, texColor1, mask);\n" + 
        "}";

public SprayRenderer(ShapeRenderer renderer) {
        super();
        this.renderer = renderer;

        ShaderProgram.pedantic = false;

        spriteBatch = new SpriteBatch();

        tex0 = new Texture(Gdx.files.internal("snowman_back.png"));
        mask = new Texture(Gdx.files.internal("balwan_maska.png"));

        maskBuff = new FrameBuffer(Format.RGBA8888, frmSizeX, frmSizeY, false);
        msk = new TextureRegion(maskBuff.getColorBufferTexture());

        frmBuff = new FrameBuffer(Format.RGBA8888, frmSizeX, frmSizeY, false);
        frm = new TextureRegion(frmBuff.getColorBufferTexture());

        frmCam = new OrthographicCamera(frmSizeX, frmSizeY);
        frmCam.translate(frmSizeX / 2, frmSizeY / 2);


        frmCam.update();
        renderer.setProjectionMatrix(frmCam.combined);
        frmBuff.begin();

        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        frmBuff.end();



        SpriteBatch batch = new SpriteBatch();

        frmCam.update();
        batch.setProjectionMatrix(frmCam.combined);
        maskBuff.begin();

        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(mask, 0, 0, 0, 0, 500, 700, 1, 1, 0, 0, 0, 500, 700, false, true);
        batch.end();

        maskBuff.end();

        shader = new ShaderProgram(VERT, FRAG);
        if (!shader.isCompiled()) {
            System.err.println(shader.getLog());
            System.exit(0);
        }
        if (shader.getLog().length()!=0)
            System.out.println(shader.getLog());


        shader.begin();
        shader.setUniformi("u_texture1", 1);
        shader.setUniformi("u_mask", 2);
        shader.end();

        //bind mask to glActiveTexture(GL_TEXTURE2)
        msk.getTexture().bind(2);

        //bind dirt to glActiveTexture(GL_TEXTURE1)
//      tex1.bind(1);
        frm.getTexture().bind(1);

        //now we need to reset glActiveTexture to zero!!!! since sprite batch does not do this for us
        Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);       
    }

        @Override
    public void draw(Batch batch, float parentAlpha) {      
        batch.flush();
        batch.setShader(shader);    
        batch.draw(tex0, getX() + MASK_OFFSET_X, getY() + MASK_OFFSET_Y);
        batch.flush();
        batch.setShader(null);
    }
}