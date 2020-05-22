/************/
        InputStream is = getClass().getResourceAsStream(s);
        AudioInputStream ais;
        BufferedInputStream bis = new BufferedInputStream(is);
        ais = AudioSystem.getAudioInputStream(bis);
        /************/