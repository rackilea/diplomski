public static void execCommand(String command) {
    try {
        Process proc = Runtime.getRuntime().exec(command);

        // Read the output
        BufferedReader reader = new BufferedReader(new 
            InputStreamReader(proc.getInputStream()));

        String line = "";
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(proc.getOutputStream()));
        writer.append("data/test2.jpg");
        writer.newLine();
        // **** add flush here ****
        writer.flush();
        // and remember to close your resource too
        writer.close();
        //reader.readLine();
        while ((line = reader.readLine()) != null) {
            System.out.print(line + "\n");
            s.add(line);
        }
        // ***** close your reader also ****
        reader.close();
        //            proc.waitFor();
    } catch (IOException e) {
        System.out.println("exception thrown: " + e.getMessage());
    } 
}