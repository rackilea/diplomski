public static void main(String[] args) {
    try {
        File file = new File(args[0]);
        BackwardsReader reader = new BackwardsReader(file, "UTF-8");
        int lineCount = 0;
        for (;;) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }
            ++lineCount;
            System.out.println(line);
        }
        reader.close();
        System.out.println("Lines: " + lineCount);
    } catch (IOException ex) {
        Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
    }
}