import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;

public class TextFadeTest extends BasicGame {

    private final int Y_OFFSET = 50;
    private final org.newdawn.slick.Color bgColor =  new org.newdawn.slick.Color(126, 166, 240);

    private UnicodeFont unicodeFont;

    public TextFadeTest(String gamename) {
        super(gamename);
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        gc.setShowFPS(false);
        gc.getGraphics().setBackground(bgColor);

        Font awtFont = new Font(Font.SERIF, Font.PLAIN, 36);
        unicodeFont = new UnicodeFont(awtFont);
        unicodeFont.getEffects().add(new ColorEffect(java.awt.Color.WHITE));
        unicodeFont.addAsciiGlyphs();
        unicodeFont.loadGlyphs();
    }

    @Override
    public void update(GameContainer gc, int i) throws SlickException {}

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {

        String str = "bernhardkiv: hello world!";
        int y = 0;
        unicodeFont.drawString(10, y, str);
        unicodeFont.drawString(10, y+=Y_OFFSET, str, Color.white, 0, 22);
        unicodeFont.drawString(10, y+=Y_OFFSET, str, 22, 0f);
        unicodeFont.drawString(10, y+=Y_OFFSET, str, 22, 0.10f);
        unicodeFont.drawString(10, y+=Y_OFFSET, str, 22, 0.25f);
        unicodeFont.drawString(10, y+=Y_OFFSET, str, 22, 0.50f);
        unicodeFont.drawString(10, y+=Y_OFFSET, str, 22, 0.75f);
        unicodeFont.drawString(10, y+=Y_OFFSET, str, 22, 0.90f);
        unicodeFont.drawString(10, y+=Y_OFFSET, str, 22, 1.0f);

    }

    public static void main(String[] args) {
        try {
            AppGameContainer appgc;
            appgc = new AppGameContainer(new TextFadeTest("TextFadeTest"));
            appgc.setDisplayMode(640, 480, false);
            appgc.start();
        }
        catch(SlickException ex) {
            Logger.getLogger(TextFadeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}