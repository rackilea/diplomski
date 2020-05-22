IIOImage iioimg = reader.readAll(0, readParam);  // image AND metadata in one go

RenderedImage image = iioimg.getRenderedImage(); // normally a BufferedImage
// ... image manipulation   
iioimg.setRenderedImage(modifiedImage);          // in case the reference changed

writer.write(null, iioimg, writeParam);          // will preserve compression by default