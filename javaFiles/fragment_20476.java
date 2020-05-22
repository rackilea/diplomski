public class MainMenu
{       
    private Texture background;
    private TrueTypeFont doomfont;
    private boolean ana = false;

    public MainMenu() { }

    public void loadData()
    {
        // Load the background texture
        try {
            background = TextureLoader.getTexture("PNG",new FileInputStream(new File("res/textures/mainmenu/doom_00340461.png")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Display.destroy();
        } catch (IOException e) {
            e.printStackTrace();
            Display.destroy();
        }
        // Load and initialize the font here
        try {
            InputStream inputStream = ResourceLoader.getResourceAsStream("res/fonts/DooM.ttf");
            Font awtFont = Font.createFont(Font.TRUETYPE_FONT,inputStream);
            awtFont = awtFont.deriveFont(24f);
            doomfont = new TrueTypeFont(awtFont,ana);
        } catch(Exception e) {
            e.printStackTrace();
        }       
    }

    public void draw()
    {
        glClear(GL_COLOR_BUFFER_BIT);
        glEnable(GL_TEXTURE_2D);
        glClearColor(0.0f,0.0f,0.0f,0.0f);
        glEnable(GL11.GL_BLEND);
        glBlendFunc(GL11.GL_SRC_ALPHA,GL11.GL_ONE_MINUS_SRC_ALPHA);
        glViewport(0,0,DoomMain.WIDTH,DoomMain.HEIGHT);
        glMatrixMode(GL11.GL_MODELVIEW);
        glMatrixMode(GL11.GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0,DoomMain.WIDTH,DoomMain.HEIGHT,0,1,-1);
        glMatrixMode(GL11.GL_MODELVIEW);    
        glShadeModel(GL_SMOOTH);

        drawBackground();
        drawText();
        glDisable(GL_TEXTURE_2D);   
    }

    private void drawBackground() 
    {
        ... bind background texture
        ... draw your quad  
    }

    private void drawText() 
    {       
        doomfont.drawString(....);
    }
}