public static void main(String... args) throws IOException {
    long start1 = System.nanoTime();
    PrintWriter pw = new PrintWriter("deleteme.txt");
    StringBuilder sb = new StringBuilder();
    for (int j = 1000; j < 1040; j++)
        sb.append(j).append(' ');
    String outLine = sb.toString();
    for (int i = 0; i < 1000 * 1000; i++)
        pw.println(outLine);
    pw.close();
    long time1 = System.nanoTime() - start1;
    System.out.printf("Took %f seconds to write%n", time1 / 1e9);

    {
        long start = System.nanoTime();
        FileReader fr = new FileReader("deleteme.txt");
        char[] buffer = new char[1024 * 1024];
        while (fr.read(buffer) > 0) ;
        fr.close();
        long time = System.nanoTime() - start;
        System.out.printf("Took %f seconds to read text as fast as possible%n", time / 1e9);
    }
    {
        long start = System.nanoTime();
        BufferedReader br = new BufferedReader(new FileReader("deleteme.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] words = line.split(" ");
        }
        br.close();
        long time = System.nanoTime() - start;
        System.out.printf("Took %f seconds to read lines and split%n", time / 1e9);
    }
    {
        long start = System.nanoTime();
        BufferedReader br = new BufferedReader(new FileReader("deleteme.txt"));
        String line;
        Pattern splitSpace = Pattern.compile(" ");
        while ((line = br.readLine()) != null) {
            String[] words = splitSpace.split(line, 0);
        }
        br.close();
        long time = System.nanoTime() - start;
        System.out.printf("Took %f seconds to read lines and split (precompiled)%n", time / 1e9);
    }
    {
        long start = System.nanoTime();
        BufferedReader br = new BufferedReader(new FileReader("deleteme.txt"));
        String line;
        List<String> words = new ArrayList<String>();
        while ((line = br.readLine()) != null) {
            words.clear();
            int pos = 0, end;
            while ((end = line.indexOf(' ', pos)) >= 0) {
                words.add(line.substring(pos, end));
                pos = end + 1;
            }
            // words.
            //System.out.println(words);
        }
        br.close();
        long time = System.nanoTime() - start;
        System.out.printf("Took %f seconds to read lines and break using indexOf%n", time / 1e9);
    }
}