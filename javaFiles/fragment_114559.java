public static void namechange() {
    try {
        String fileorig = "C:\\Users\\danor\\Desktop\\example.txt";
        String asf;
        String line;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("what do you want the new file to be named.");
        StringBuilder file = new StringBuilder();
        file.append("C:\\Users\\danor\\Desktop\\");
        file.append(keyboard.nextLine());
        file.append(".txt");
        asf = file.toString();
        try {
            FileWriter fwriter = new FileWriter(asf, true);
            PrintWriter out = new PrintWriter(fwriter);
            Scanner inputfile = new Scanner(fileorig);
            if (inputfile.hasNextLine()) {
                while (inputfile.hasNextLine()) {
                    line = (inputfile.nextLine());
                    out.println(line);
                }
                System.out.println("line");
            } else {
                System.out.println("Reached the end of the file");
            }

            //close the PrintWriter when you finish writing to the file
            out.close();

        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            System.out.println("something went wrong with the writing : " + e.getMessage());
        }

    } catch (Exception e) {
        System.out.println("there was something wrong witht the reading : " + e.getMessage());

    }
}