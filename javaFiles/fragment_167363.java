for(Socket s : Store.getAll()) {
    try {
        if (s.getInputStream().available() != 0) {
            byte[] buffer = new byte[s.getInputStream().available()];
            s.getInputStream().read(buffer);
            new Processing(s, buffer);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}