// ... some code ...
IIOMetadata meta = reader.getImageMetadata(0);
Element tree = (Element) meta.getAsTree("javax_imageio_jpeg_image_1.0");
IIOMetadataNode comNode = (IIOMetadataNode)tree.getElementsByTagName("com").item(0);
comNode.setUserObject(new String("FOOOOOOOOOO!").getBytes("ISO-8859-1"));
meta.setFromTree("javax_imageio_jpeg_image_1.0", tree);
// ... smoe code ...