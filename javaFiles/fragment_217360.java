public static void writeToFile(String text) {

    String heading = "Some heading";

    try {
        File f = new File("test.txt");
        FileWriter writer = new FileWriter(f, true); 

        if(f.exists() && !f.isDirectory()) {
          writer.write(heading);
       } 

        writer.write(text);

    } catch (IOException ex) {
        System.out.println(ex.getMessage());
    }finally{
        writer.close();
    }
}