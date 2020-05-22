public class Quiz4 {
        public static void main(String[] args) {
            File input = new File("mystery.txt");
            try {
                double answer = 0;
                FileReader fr = new FileReader(input);
                BufferedReader br = new BufferedReader(fr);
                String currentLine = br.readLine();
                while (currentLine != null) {
                    currentLine = br.readLine();
                    Double curDouble = tryParseDouble(currentLine);
                    if (curDouble != null) {
                        answer += curDouble;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static Double tryParseDouble(String str) {
            try {
                return Double.parseDouble(str);
            } catch (Exception e) {
                return null;
            }

        }
    }