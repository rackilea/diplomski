float[] matrix = {
             1,  0, -1,
             0,  0,  0,
            -1,  0,  1
    };
    BufferedImageOp op = new ConvolveOp(new Kernel(3, 3, matrix));