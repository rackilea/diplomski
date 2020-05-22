public void draw(Batch batch, float parentAlpha) {
        if(shaderActive) {
            batch.setShader(Assets.assetFont.fontShader);
        }
        Assets.assetFont.fontShader.setUniformf("u_newAlpha", parentAlpha);
        super.draw(batch, parentAlpha);
        batch.setShader(null);          
    }