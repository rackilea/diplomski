void myMethod(String [] argument3, File file) throws IOException {
    String[] cmd = {"command", "argument 1", "argument 2"};
    try (PrintWriter fileWriter = new PrintWriter (file)) {
        for (int i = 0; i < argument3.length; i++) {
            Process process = Runtime.getRuntime().exec(cmd);
            try (Scanner fileScanner = new Scanner(process.getInputStream())) {
                cmd[3] = argument3[i];
                while (fileScanner.hasNextLine()) {
                    fileWriter.println(fileScanner.nextLine());
                }
            }
        }
    }
}