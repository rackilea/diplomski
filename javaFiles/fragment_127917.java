public static void main(String[] args) {
        // TODO code application logic here
        String filename = "<//Enter the location you want the file//>";
        FileWriter fstream;

        try {
            fstream = new FileWriter(filename);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write("My Name is Bobby Bob");
            out.newLine();                                  
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();          
      }

    }