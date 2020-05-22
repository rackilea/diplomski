public static void saveAsDialog(String fileContent){
    // your code

    FileWriter fw = new FileWriter(saveas.getSelectedFile()+".gpx");
    fw.write(fileContent)

    fw.close();