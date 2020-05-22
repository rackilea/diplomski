ArrayList<String> result = new ArrayList<String>(); //ArrayList cause you don't know how many files there is
    File folder = new File("PATH/TO/YOUR/FOLDER/AS/STRING"); //This is just to cast to a File type since you pass it as a String
    File[] filesInFolder = folder.listFiles(); // This returns all the folders and files in your path
    for (File file : filesInFolder) { //For each of the entries do:
        if (!file.isDirectory()) { //check that it's not a dir
            result.add(new String(file.getName())); //push the filename as a string
        }
    }

    return result;