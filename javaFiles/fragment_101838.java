switch ( image.getType() )
    {
    case BufferedImage.TYPE_BYTE_GRAY : // Classical gray level images.
        byte[] bb = ((DataBufferByte)image.getRaster().getDataBuffer()).getData() ;
        for (int i=0 ; i < bb.length ; i++)
            pixels[i] = bb[i] & 0xFF ;
        break ;
    }