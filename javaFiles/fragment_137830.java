public static void main(String[] args) throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader("in.txt"));
         BufferedWriter writer = new BufferedWriter(new FileWriter("out.txt"))) {
        int c;
        char character;
        while ((c = reader.read()) != -1) {
            character = (char) c;
            if (character == ',')
                writer.write('\n');
            else
                writer.write(character);
        }
    }
}