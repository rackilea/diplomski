// Read the file contents
    try {
        BufferedReader in = new BufferedReader(new FileReader(file));
        // If you got this far, the file is open...
        // use try/finally to ensure closure.
        try {
            while((line = in.readLine()) != null) {
                fullText+=line+"\n";
            }
        }
        finally {
          in.close();
        }
    }
    catch(FileNotFoundException e) {
        e.printStackTrace();
    }
    catch(IOException e) {
        e.printStackTrace();
    }