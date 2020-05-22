public class CopyToString {
    static class Line {
        String word;
        int num1, num2;

        Line(String word, int num1, int num2) {
            this.word = word;
            this.num1 = num1;
            this.num2 = num2;
        }

        @Override
        public String toString() {
            return "Line{" + "word='" + word + '\'' + ", num1=" + num1 + ", num2=" + num2 + '}';
        }
    }

    public static void main(String... args) throws IOException {
        String fileSpecified = args[0] + ".txt";
        System.out.println("file Specified = " + fileSpecified);
        BufferedReader br = new BufferedReader(new FileReader(fileSpecified));

        List<Line> lines = new ArrayList<Line>();
        for (String line; (line = br.readLine()) != null;) {
            Scanner scanner = new Scanner(line);
            lines.add(new Line(scanner.next(), scanner.nextInt(), scanner.nextInt()));
        }
        br.close();

        for (Line l : lines)
            System.out.println(l);
    }
}