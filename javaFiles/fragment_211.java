public static void clearTheFile() {
        FileWriter fwOb = new FileWriter("FileName", false); 
        PrintWriter pwOb = new PrintWriter(fwOb, false);
        pwOb.flush();
        pwOb.close();
        fwOb.close();
    }