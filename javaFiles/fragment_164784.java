int[] bufferpix = new int[mLength];
    for(int i=0; i<mLength;i++){
        bufferpix[i] = buffer[i+13];
    }
    mImage = new BufferedImage(mWidth, mHeight, BufferedImage.TYPE_4BYTE_ABGR_PRE);
    mImage.getRaster().setPixels(0, 0, mWidth, mHeight, bufferpix);