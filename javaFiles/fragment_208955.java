public class Part2 {

    public static void doIt(BufferedReader r, PrintWriter w) throws IOException {
        List<String> allStrings = new ArrayList<String>();
        String line;
        int minLength = 0;
        while ((line = r.readLine()) != null) {
            if (minLength == 0 || minLength > line.length()) {
                allStrings.add(line);
                minLength = line.length();
            }
        }

        for (String text : allStrings) {
            w.println(text);
        }
    }

    public static void main(String[] args) {
        try {
            BufferedReader r;
            PrintWriter w;
            if (args.length == 0) {
                r = new BufferedReader(new InputStreamReader(System.in));
                w = new PrintWriter(System.out);
            } else if (args.length == 1) {
                r = new BufferedReader(new FileReader(args[0]));
                w = new PrintWriter(System.out);
            } else {
                r = new BufferedReader(new FileReader(args[0]));
                w = new PrintWriter(new FileWriter(args[1]));
            }
            long start = System.nanoTime();
            doIt(r, w);
            w.flush();
            long stop = System.nanoTime();
            System.out.println("Execution time: " + 10e-9 * (stop - start));
        } catch (IOException e) {
            System.err.println(e);
            System.exit(-1);
        }
    }
}