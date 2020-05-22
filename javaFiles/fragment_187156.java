class TestFramePosition {
    public static void main(String[] a) throws Exception {
        File file = new File(a.length > 0 ? a[0] : "path/to/file.extension");
        AudioInputStream ais = AudioSystem.getAudioInputStream(file);
        final Clip clip = AudioSystem.getClip();

        clip.open(ais);
        clip.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(clip.isRunning()) {
                    try {
                        System.out.println(clip.getMicrosecondPosition());
                        Thread.sleep(1000 / 10);
                    } catch(InterruptedException ignored) {}
                }
            }
        }).start();

        System.in.read();
        System.exit(0);
    }
}