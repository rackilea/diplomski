package com.test;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Bundle;

public class ColorTriangleTest extends Activity{

    GLSurfaceView glView;
    ByteBuffer byteBuffer;
    FloatBuffer vertices;

    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        int VERTEX_SIZE = (2+4)*4;
        byteBuffer = ByteBuffer.allocateDirect(3*VERTEX_SIZE);
        byteBuffer.order(ByteOrder.nativeOrder());
        vertices = byteBuffer.asFloatBuffer();
        vertices.put(new float[] { 0.0f, 0.0f, 1, 0, 0, 1,
                                   319.0f, 0.0f, 1, 1, 0, 1,
                                   160.0f, 479.0f, 1, 0, 1, 1 });
        vertices.flip();

        glView = new GLSurfaceView(this);
        glView.setRenderer(new Render());
        setContentView(glView);
    }

    class Render implements Renderer {

        @Override
        public void onDrawFrame(GL10 gl) {

            int VERTEX_SIZE = (2+4)*4;

            gl.glViewport(0, 0, glView.getWidth(), glView.getHeight());
            gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
            gl.glMatrixMode(GL10.GL_PROJECTION);
            gl.glLoadIdentity();
            gl.glOrthof(0, 320, 0, 480, 10, -10);

            gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
            gl.glEnableClientState(GL10.GL_COLOR_ARRAY);

            vertices.position(0);
            gl.glVertexPointer(2, GL10.GL_FLOAT, VERTEX_SIZE, vertices);
            vertices.position(2);
            gl.glColorPointer(4, GL10.GL_FLOAT, VERTEX_SIZE, vertices);

            gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 3);

        }

        @Override
        public void onSurfaceChanged(GL10 gl, int width, int height) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onSurfaceCreated(GL10 gl, EGLConfig config) {
            // TODO Auto-generated method stub

        }

    }

}