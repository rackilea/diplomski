package com.mhsjlw.heat;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Heat extends ApplicationAdapter {

    private SpriteBatch batch;
    private Texture img;
    private OrthographicCamera camera;

    private FlirClient flir = new FlirClient("69.165.165.194", 2525);
    private int[] palette = FlirPalette.IRONBOW_PALETTE;
    private byte[] frame = new byte[4800];

    @Override
    public void create() {

        flir.run();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 80, 60);
        batch = new SpriteBatch();

        //this is useless here
        Pixmap pixmap = new Pixmap( 80, 60, Format.RGB888);

        pixmap.drawPixel(1, 1);
    }

    @Override
    public void render() {

        camera.update();

        Pixmap pixmap = new Pixmap( 80, 60, Format.RGB888);

        while(true) { //add a condition!

            frame = flir.getFrame();

            for (int row=0; row<60; row++) {
                for (int col=0; col<0; col++) {
                    int ndx = row * 80 + col;
                    pixmap.drawPixel(col, row, FlirPalette.getRgb888(frame[ndx], palette));
                }
            }

            img = new Texture(pixmap); //create Texture from Pixmap
            pixmap.dispose(); //do not leak memory
            batch.begin();
            batch.draw(img, 100, 100); //draw pixmap texture
            batch.end();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}