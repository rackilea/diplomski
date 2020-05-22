SF2LayerRegion region = new SF2LayerRegion();
        region.putInteger(SF2Region.GENERATOR_RELEASEVOLENV, 12000); 
        region.putBytes(SF2Region.GENERATOR_KEYRANGE, new byte[]{(byte)(60+i),(byte)(60+i)});
        i++;
        region.setSample(sample);
        layer.getRegions().add(region);