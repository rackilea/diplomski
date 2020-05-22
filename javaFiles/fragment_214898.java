```
    private static void B() {
        String filename = "C:\\test.wav";
        InputStream in = null;
        try {
            in = new FileInputStream(filename);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
        try {
            AudioStream s = new AudioStream(in);
            AudioPlayer.player.start(s);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

```