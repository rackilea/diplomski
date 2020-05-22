// Write the replaced text to file
    try {
        BufferedWriter out = new BufferedWriter(new FileWriter(file));
        try {
            out.write(fullText);
        }
        finally {
            out.close();
        }
    }
    catch(FileNotFoundException e) {
        e.printStackTrace();
    }
    catch(IOException e) {
        e.printStackTrace();
    }