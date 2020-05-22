private static Scanner getFile() {
        Scanner in = new Scanner(System.in);
        Scanner scannedFile = new Scanner(System.in);
        String inputFile;
        boolean validFile = false;

        while (!validFile) {
            try {
                System.out.print("Enter your file name: ");
                inputFile = in.nextLine();
                scannedFile = new Scanner(new FileReader(inputFile));
                validFile = true;
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Invalid File");
                //no scanned file, input file could not find
                scannedFile = null;
                //file was not valid
                validFile = false;
            }
        }
        return scannedFile;
    }