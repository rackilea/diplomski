public static void main(String args[]) {
    TCPServer server = new TCPServer(999);
    Sound     sound  = null;

    for (;;) {
        String command = server.accept();

        if (command.equals("UPDATE_DATABASE)) {
            // generate xml
            server.sendData(xml.getRawContent());
        } else if (command.equals("PLAY_SONG")) {
            String filename = server.accept();

            sound = new Sound(filename);
            sound.play();
        } else if (command.equals("PAUSE_SONG")) {
            if (sound.playing()) {
                sound.pause();
            } else {
                sound.play();
            }
        }
    }
}