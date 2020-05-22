public static void main(String[] args) throws IOException {

    File file = new File("song.mp3");

    FileInputStream fIn = new FileInputStream("song.mp3");
    FileOutputStream fOut = new FileOutputStream("song_0.mp3");
    int chunk_size = 1024 * 100;
    byte[] buff = new byte[chunk_size]; // 100KB file
    int i = 0;
    String file_name = file.getName();
    String file_name_base = file_name.substring(0, file_name.lastIndexOf("."));
    while (fIn.read() != -1) {

        fIn.read(buff);
        int total_read = 0;
        total_read += chunk_size;
        long read_next_chunk = total_read;
        String file_name_new = file_name_base + "_" + i + ".mp3";
        File file_new = new File(file_name_base);
        i++;
        fOut = new FileOutputStream(file_name_new);
        fOut.write(buff);

        fIn.skip(total_read);// skip the total read part

    } // end of while loop

    fIn.close();
    fOut.close();

}