try { 
    FileInputStream fileInput = new FileInputStream(fileName);
    Scanner fileIn = new Scanner(new FileReader(fileName));
    String fileWord = fileIn.next();

    ArrayList<String> newSubList = new ArrayList<>();
        while (fileIn.hasNext()){
            fileWord = fileIn.next();

            //Adds to this specific Arraylist:
            newSubList.add(fileWord);
        }

        //Adds to the outermost ArrayList after loop
        fileByLine.add(newSubList);
    } 

catch (IOException ex) {
        System.out.println("Error reading file.");
    }