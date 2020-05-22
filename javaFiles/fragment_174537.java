SeekableStream s = new FileSeekableStream(inFile);
        TIFFDecodeParam param = null;
        ImageDecoder dec = ImageCodec.createImageDecoder("tiff", s, param);
        RenderedImage op = dec.decodeAsRenderedImage(0);

        FileOutputStream fos = new FileOutputStream(otPath);
        JPEGEncodeParam jpgparam = new JPEGEncodeParam();
        jpgparam.setQuality(67);
        ImageEncoder en = ImageCodec.createImageEncoder("jpeg", fos, jpgparam);
        en.encode(op);
        fos.flush();
        fos.close();