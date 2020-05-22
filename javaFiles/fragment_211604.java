ImageView iv = new ImageView(image);
iv.setRotate(40);
SnapshotParameters params = new SnapshotParameters();
params.setFill(Color.TRANSPARENT);
Image rotatedImage = iv.snapshot(params, null);
gc.drawImage(rotatedImage, 0, 0);