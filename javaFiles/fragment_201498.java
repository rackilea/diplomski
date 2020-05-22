public class ReadFromTextFile {

        private final String everything;

        public ReadFromTextFile() throws IOException {
            try(BufferedReader br = new BufferedReader(new FileReader("text.txt"))) {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                this.everything = sb.toString();
            }
        }

        public static void main(String[] args) throws IOException {

            ReadFromTextFile obj1 = new ReadFromTextFile(); 
            System.out.println(obj1.everything);
        }

    }