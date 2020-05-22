new ImageIcon( url ).setImageObserver( new ImageObserver() {
    public void imageUpdate( Image img, int infoFlags, int x, int y, int width, int height ) {
        if( infoFlags & ImageObserver.FRAMEBITS == ImageObserver.FRAMEBITS ) {
            // another frame was loaded do something with it.
        }
    }
});