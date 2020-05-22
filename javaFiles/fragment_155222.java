// Read the audio file into waveData:
    BufferedInputStream in = new BufferedInputStream(url.openStream());
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    for (;;) {
        int b = in.read();
        if (b == -1) {
            break;
        }
        bos.write(b);
    }
    in.close();
    bos.close();
    byte[] waveData = bos.toByteArray();

    // Create the AudioInputSteam:
    ByteArrayInputStream bis = new ByteArrayInputStream(waveData);
    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(bis);