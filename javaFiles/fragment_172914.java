public void getFiles(String dir) throws IOException {
        File directory = new File(dir);
        //Verify if it is a valid file name

        System.out.println("Looking for files in directory: " + dir);
        if (!directory.exists()) {
            System.out.println(String.format("Directory %s does not exist", dir));
            return;
        }
        //Verify if it is a directory and not a file path
        if (!directory.isDirectory()) {
            System.out.println(String.format("Provided value %s is not a directory", dir));
            return;
        }
        System.out.printf("files found in dir: %s%n", Arrays.asList(directory.listFiles()));
        //create a FileFilter and override its accept-method
        FileFilter logFilefilter = new FileFilter() {
            //Override accept method
            public boolean accept(File file) {
                //if the file extension is .smali return true, else false
                if (file.getName().endsWith(".smali")) {
                    return true;
                }
                return false;
            }
        };

        File[] files = directory.listFiles(logFilefilter);

        // create an additional scanner to store the userInput (the word you want to find).
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter the word that you want to find in the .smali files: ");
        String seekWord = userInput.nextLine(); //this line will store the line you are looking for
        userInput.close();

        // create an arrayList to store all the files that contain the word.
        List<File> filesWithWord = new ArrayList<>();



        //Let's list out the filtered files
        for (File f : files) {
            Scanner sc = new Scanner(f);
            while (sc.hasNext()) {
                // look in each line and if the line contains the word store the file.
                String line = sc.nextLine();
                if (line.contains(seekWord)) {
                    System.out.println("found word " + seekWord + " in file: " + f.getName());
                    filesWithWord.add(f);
                    break; // no need to go through the rest of the lines.
                }

            }
            sc.close();
        }

        System.out.println("Smali files with the word: " + filesWithWord);
        // create another file to store the results
        File fileWithFoundFiles = new File("path/to/file/files.txt");
        //make sure the parents of the file exist.
        fileWithFoundFiles.getParentFile().mkdirs();
        if (!fileWithFoundFiles.exists()) {
            fileWithFoundFiles.createNewFile();
        }
        try (FileWriter writer = new FileWriter(fileWithFoundFiles)) { //try-with resources so your resource gets closed automatically
            for (File f : filesWithWord) {
                //write the fileNames to the file
                System.out.println("writing file name " + f.getName() + " to " + f);
                writer.write(f.getName() + "\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }