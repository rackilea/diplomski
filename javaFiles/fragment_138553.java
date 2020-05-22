ImageObserver observer = _appropriate_value_here_;
Image image = block.getImage();
int BLOCK_X_DIM = image.getHeight(observer);   // The height of a block
int BLOCK_Y_DIM = image.getWidth(observer);    // The width of a block
for(int i = 0; i < 5; i++) {
    for(int j = 0; j < 5; j++) {
        g2d.drawImage(image, BLOCK_X_DIM * i, BLOCK_Y_DIM * j, null);
    }
}