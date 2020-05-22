class IntroRenderer implements GLSurfaceView.Renderer {

    private boolean textureReady = false;

    public void onDrawFrame(GL10 gl) {

        if (!this.textureReady) {
            this.prepareTexture(gl); // only initialize once
        }           

        gl.glClearColor(0, 0.4f, 0.4f, 1.0f);
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        float positions[] = { 
                      0.0f, 1.0f, 0.0f, 
                      0.0f, 0.0f, 0.0f, 
                      1.0f, 1.0f, 0.0f,
          0.0f, 0.0f, 0.0f, 
                      1.0f, 1.0f, 0.0f, 
                      1.0f, 0.0f, 0.0f };

        float texCoords[] = {  // define texture coordinates
                      0.0f, 1.0f, 
                      0.0f, 0.0f, 
                      1.0f, 1.0f, 
                      0.0f, 0.0f, 
                      1.0f, 1.0f, 
                      1.0f, 0.0f };

        ByteBuffer bb = ByteBuffer.allocateDirect(positions.length * 4);
        bb.order(ByteOrder.nativeOrder());

        FloatBuffer fb = bb.asFloatBuffer();
        fb.put(positions);
        fb.position(0);

        // create buffer for texture coordinates
        ByteBuffer texCoordByteBuffer = ByteBuffer.allocateDirect(texCoords.length * 4);
        texCoordByteBuffer.order(ByteOrder.nativeOrder());

        FloatBuffer texCoordBuffer = texCoordByteBuffer.asFloatBuffer();
        texCoordBuffer.put(texCoords);
        texCoordBuffer.position(0);

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, fb);

        // enable texture buffer
        gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
        gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, texCoordBuffer);

        gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 3 * 2);


    }

    private void prepareTexture(GL10 gl) {
        int[] buffers = new int[1];
        gl.glGenTextures(1, buffers, 0);
        int texture = buffers[0];

        // enable texturing and bind texture
        gl.glEnable(GL10.GL_TEXTURE_2D);
        gl.glBindTexture(GL10.GL_TEXTURE_2D, texture);

        Bitmap bmp = BitmapFactory.decodeResource(IntroActivity.this.getResources(), R.drawable.rect2985);
        Bitmap bmp256 = Bitmap.createScaledBitmap(bmp, 256, 256, false);

        GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, bmp256, 0);

        // setup filters
        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_NEAREST);
        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER, GL10.GL_NEAREST);

        bmp.recycle();
        this.textureReady = true;
    }

    public void onSurfaceChanged(GL10 gl, int width, int height) {
        gl.glViewport(0, 0, width, height);
    }

    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        // TODO Auto-generated method stub
    }

}