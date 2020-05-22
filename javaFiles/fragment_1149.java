public void load()
{
    try{
        int []texture = new int[1];
        gl.glGenTextures(1, texture,0);//the missing method
        textureId = texture[0];
        //now you can call
        AssetManager assetManager = context.getAssets();
        InputStream is = assetManager.open(texturePath);
        texture = BitmapFactory.decodeStream(is);
        gl.glBindTexture(GL10.GL_TEXTURE_2D, textureId);/*this fails 
          if textureId is a 'random' number. You must/should generate a valid id. */
        GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, texture, 0);
        setFilters(GL10.GL_NEAREST, GL10.GL_NEAREST);
        gl.glBindTexture(GL10.GL_TEXTURE_2D, 0);