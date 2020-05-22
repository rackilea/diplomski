private static char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static StringBuilder partialSolution = new StringBuilder();
    private static File fout = new File("out.txt");
    private static FileOutputStream fos;
    private static BufferedWriter bw;
    static {
        try {
            fos = new FileOutputStream(fout);
            bw = new BufferedWriter(new OutputStreamWriter(fos));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }