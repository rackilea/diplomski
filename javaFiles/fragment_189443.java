// set JPG params
JPEGImageWriteParam param = new JPEGImageWriteParam(Locale.getDefault());
param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
param.setCompressionQuality(1);
param.setOptimizeHuffmanTables(true);

// save the image with new comment inside
IIOImage iioimage = new IIOImage(img, null, meta);
writer.setOutput(ImageIO.createImageOutputStream(new File("some_modified.jpg")));
writer.write(null, iioimage, param);