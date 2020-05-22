BufferedImage img = <your image>
    for( int i = 0; i < img.getWidth( ); i++ )
        for( int j = 0; j < img.getHeight( ); j++ ) {
            // get argb from pixel
            int coli = img.getRGB( i, j );
            int a = coli >> 24 & 0xFF;
            int r = coli >> 16 & 0xFF;
            int g = coli >> 8 & 0xFF;
            int b = coli & 0xFF;
            coli &= ~0xFFFFFFFF;
            // do what you want with a, r, g and b, in your case :
            a = 0xFF;
            // save argb
            coli |= a << 24;
            coli |= r << 16;
            coli |= g << 8;
            coli |= b << 0;
            img.setRGB( i, j, coli );
        }
    }