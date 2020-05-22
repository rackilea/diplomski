public static void main(String[] args) {

        Scanner file;
        PrintWriter writer;

        try {

            file = new Scanner(new File("src/data.txt"));
            writer = new PrintWriter("src/data2.txt");

            while (file.hasNext()) {
                String line = file.nextLine();
                if (!line.isEmpty()) {
                    writer.write(line);
                    writer.write("\n");
                }
            }

            file.close();
            writer.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
}