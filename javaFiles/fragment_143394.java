InputParameters parameters = parts.getParameters();
    int audioFileID = parameters.getIntParameter("audiofileID");

    //Retrieves Audio File
    AudioFile audioFile = CallManager.getAudioFile(audioFileID);
    InputStream is = new ByteArrayInputStream(audioFile.getAudio());

    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(is);
    ServletOutputStream out = response.getOutputStream();
    ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();

    AudioFormat format = audioInputStream.getFormat();
  audioInputStream = AudioSystem.getAudioInputStream(format, audioInputStream);
    }

    AudioSystem.write(audioInputStream,javax.sound.sampled.AudioFileFormat.Type.WAVE,byteOutputStream);