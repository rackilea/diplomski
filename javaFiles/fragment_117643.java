public void   SaveToFile() throws IOException {
    int userSelection = db.showSaveDialog(this);
    if (userSelection == JFileChooser.APPROVE_OPTION) {
        File fileToSave = db.getCurrentDirectory();
        String path = fileToSave.getAbsolutePath() + File.separator + "test.txt";

        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                  new FileOutputStream(path), "utf-8"))) {
            int i=0;
            //String Data[]=new String[10];
            while( i<10 ){
                writer.write("Student No :" + i);
                //Data[i]= "Student No :" + i; // Not sure why Data[] exists?
                ++i;
            }
        }

        System.out.println("Save as file: " + path);
    }
}