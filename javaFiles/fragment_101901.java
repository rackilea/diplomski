private static BufferedWriter bw;

public static void main(String[] args) {

    File file = new File("/your/file/path/<filename>");

    // if file doesnt exists, then create it
    if (!file.exists()) {
        file.createNewFile();
    }

    FileWriter fw = new FileWriter(file.getAbsoluteFile());
    BufferedWriter bw = new BufferedWriter(fw);

    postOrderTrav(node);

    bw.close();
}