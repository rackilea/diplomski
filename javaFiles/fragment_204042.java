int attempt = 0;

    while(highestBlock < 35) {
        attempt++;
        blocks.clear();
        int hb = 0;
        for(int x = 0; x < xWidth; x++) {
            for(int z = 0; z < zWidth; z++) {
                double noise = gen.noise(x, z, attempt*5, 0.5, 0.5) * HEIGHT * rollingParticle[x + z * xWidth];
                double noisePlusOne = noise + 1;
                for(int y = 1; y < noisePlusOne; y++) {
                    if(y > hb) hb = y;
                    if(y == ((int)noise)) {
                        blocks.add(new XYZLocation(x, y, z, true));
                    } else {
                        blocks.add(new XYZLocation(x, y, z, false));
                    }
                }

            }
        }
        System.out.println("max:" + hb);
        highestBlock = hb;
    }