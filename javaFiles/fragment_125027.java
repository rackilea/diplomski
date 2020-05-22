finally {
    try {
        in.close();
        fstream.close();
        br.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}