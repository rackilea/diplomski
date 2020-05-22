private static void createHighScoreFile() throws IOException {
        PrintWriter printWriter = new PrintWriter
            (new BufferedWriter
                    (new FileWriter("Highscores")));
        printWriter.write("0\n");
        printWriter.close();
    }

    public static void main(String[] args) throws IOException {

        createHighScoreFile();
        DecimalFormat df = new DecimalFormat("0.00");