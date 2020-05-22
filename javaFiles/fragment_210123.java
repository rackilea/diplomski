package me.tutorial;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.gluPerspective;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

/**
 * @author Chronove
 */
public class Example {

    public static void main(String[] args) throws Exception {

        int WIDTH  = 600;
        int HEIGHT = 400;

        // INIT
        Display.setDisplayMode(new DisplayMode(WIDTH,HEIGHT));
        Display.create();

        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();

        gluPerspective(45.0f,(float)(WIDTH / HEIGHT),0.1f,500f);

        glMatrixMode(GL_MODELVIEW);
        glEnable(GL_DEPTH_TEST);

        float degrees = 0;

        while(!(Display.isCloseRequested())){

            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            glLoadIdentity();

            glTranslatef(0,0,-10f);
            glRotatef(degrees++,0f,0f,1f);

            // drawQuad();
            {

                glBegin(GL_QUADS);

                glVertex3f(-1f,-1f,0f);
                glVertex3f( 1f,-1f,0f);
                glVertex3f( 1f, 1f,0f);
                glVertex3f(-1f, 1f,0f);

                glEnd();

            }

            Display.update();
            Display.sync(60);

        }

        Display.destroy();
        System.exit(0);

    }

}