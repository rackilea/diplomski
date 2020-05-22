HashMap<String, Clip> clips = new HashMap<String, Clip>();
for (String fileName: fileNames) {
    File file = new File(fileName);
    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
    Clip clip = AudioSystem.getClip();
    clip.open(audioInputStream);
    clips.put(fileName, clip);
}

clips.get("music.mid").start();