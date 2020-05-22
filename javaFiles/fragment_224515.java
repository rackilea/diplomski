//check before file name is nt null
    File ModFile =new File("somefile" + ".mod");
    FileWriter writer = null;

    try {
        writer = new FileWriter(ModFile);
        writer.write("test..................");
            // and other processing 
    } catch (IOException ex) {
        Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
    }finally{
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}