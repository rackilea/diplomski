public JavaSound(String fileName){
    try {

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(fileName);
        AudioInputStream sound = AudioSystem.getAudioInputStream(new BufferedInputStream(is));

        // load the sound into memory (a Clip)
        clip = AudioSystem.getClip();
        clip.open(sound);
    }
    catch (MalformedURLException e) {
        e.printStackTrace();
        throw new RuntimeException("Sound: Malformed URL: " + e);
    }
    catch (UnsupportedAudioFileException e) {
        e.printStackTrace();
        throw new RuntimeException("Sound: Unsupported Audio File: " + e);
    }
    catch (IOException e) {
        e.printStackTrace();
        throw new RuntimeException("Sound: Input/Output Error: " + e);
    }
    catch (LineUnavailableException e) {
        e.printStackTrace();
        throw new RuntimeException("Sound: Line Unavailable Exception Error: " + e);
    }


}