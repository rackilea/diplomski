FileOutputStream fos = new FileOutputStream("C:/test/output/myFile.tif"); 

        RenderedOp src = JAI.create("fileload", "C:/test/input/myFile.jpg");

        BufferedImage buf = new BufferedImage(src.getWidth(), src.getHeight(), BufferedImage.TYPE_BYTE_BINARY);
        buf.getGraphics().drawImage(src.getAsBufferedImage(), 0, 0, null);
        RenderedImage ri = (RenderedImage) buf;

        encodeParam = new TIFFEncodeParam ();
        encodeParam.setCompression(TIFFEncodeParam.COMPRESSION_GROUP4);

        ImageEncoder enc = ImageCodec.createImageEncoder("TIFF", fos, encodeParam);
        enc.encode(ri);