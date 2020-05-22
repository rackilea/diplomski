float pow = (float) Math.pow(2,value);
    ColorMatrix exposureMatrix= new ColorMatrix(new float[]
            {
                    pow, 0,    0, 0,  0,
                    0,    pow, 0, 0,  0,
                    0,    0,    pow,0,0,
                    0,    0,    0,    1,0
            });