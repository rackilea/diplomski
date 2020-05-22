try {
        File f = File.createTempFile("file", ".txt");
        FileWriter wr = new FileWriter(f);
        wr.write("This is a Test!");
        wr.close();
        // Add it to clipboard here 
    } catch (IOException e) {
        e.printStackTrace();
    }