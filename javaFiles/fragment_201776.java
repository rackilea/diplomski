byte[] buffer = new byte[4096];
    for (File file : files) {
        try {
            AudioInputStream is = AudioSystem.getAudioInputStream(file);
            AudioFormat format = is.getFormat();
            SourceDataLine line = AudioSystem.getSourceDataLine(format);
            line.open(format);
            line.start();
            while (is.available() > 0) {
                int len = is.read(buffer);
                line.write(buffer, 0, len);
            }
            line.drain(); //**[DEIT]** wait for the buffer to empty before closing the line
            line.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }