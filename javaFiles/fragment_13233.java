public class Test {

    public static void main(String[] args) {

        String input = "path\\to\\input\\text.txt";
        String output = "path\\to\\output\\text.txt";
        BufferedReader in;
        BufferedWriter out;
        try {
            in = new BufferedReader(new InputStreamReader(new FileInputStream(input), "UTF-8"));
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output, true), "UTF-8"));

            String line, lastLine;
            lastLine = in.readLine();
            while ((line = in.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts[2].startsWith("G")) {
                    lastLine += "   LL";
                }
                out.write(lastLine);
                out.write(System.lineSeparator());
                lastLine = line;
            }
            out.write(lastLine);

            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}