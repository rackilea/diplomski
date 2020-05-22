mp.setOnEndOfMedia(new Runnable() {
    @Override public void run() {
       app.enqueue(new Runnable() {
            @Override public void run() {
                initMediaPlayer(mediaView, actualList.getPath()+actualList.getMediaLocation());
                detachChild(node);
                node = new TextureNode("mediaManagerTextureNode");
                node.init(app, mp);
                attachChild(node);
            }
       });
    }
});