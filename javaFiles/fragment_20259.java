// this is the input file from the folder
    public static final File outFile = new File("input.txt");

    public static void main(String[] args) throws IOException {     
        getFileContents();
        changeFileContents();
    }

    // this method takes all the folder contents and puts
    // it into a text file
    public static void getFileContents() throws IOException{

        System.out.print(outFile.getAbsolutePath());
        PrintWriter out = new PrintWriter(outFile);

            Files.walk(Paths.get("C:/Location")).forEach(file -> {
                if (Files.isRegularFile(file))
                        out.println(file);
            }); 
        out.close();
    }

    // this method takes the previously made text file and makes
    // a new one only adding the file names with Thumbnail.jpg
    public static void changeFileContents() throws IOException {

        PrintWriter in = new PrintWriter(new FileWriter("output.txt"));

        Scanner scanner = new Scanner(outFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // checks to see if the image is the one I need
                if(line.contains("Thumbnail.jpg"))
                    in.println(line);
            }
        scanner.close();
        in.close();
     }