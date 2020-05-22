mp.setOnEndOfMedia(() -> {app.enqueue(() -> {
     initMediaPlayer(mediaView, actualList.getPath()+actualList.getMediaLocation());
     detachChild(node);
     node = new TextureNode("mediaManagerTextureNode");
     node.init(app, mp);
     attachChild(node);
}});