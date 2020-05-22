private static void OpenMenuActionPerformed(java.awt.event.ActionEvent evt) {  

//check before file name is nt null
    File ModFile =new File("somefile" + ".mod");
    FileOutputStream writer = null;

    String toProcess = "00D0C0DE00D0C0DE F000000000000000";

    try {
        writer = new FileOutputStream(ModFile);
        writer.write(toProcess.getBytes(),0,toProcess.getBytes().length);

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