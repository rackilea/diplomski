public String storeText(String title, String description) {

    String randomName = null;
    try {

        String baseDir = "C:/MyProjects/eclipse/DreamFolder/";
        randomName = Long.toHexString(Double.doubleToLongBits(Math.random()));
        String folderName = baseDir + randomName;
        String fileName = folderName + "/textCon.txt";

        File fileFolder = new File(folderName);
        fileFolder.mkdir();
        boolean exists = fileFolder.exists();
      if (!exists) {
        System.out.println("storeText folder does not exist");
      }
        System.out.println("storeText folderName - " + folderName);
        System.out.println("storeText fileName - " + fileName);

        File file = new File(fileName);
        BufferedWriter out = new BufferedWriter(new FileWriter(file));
        out.write(title);
        out.newLine();
        out.write(randomName);
        out.newLine();
        out.write(description);
        out.flush();
        out.close();
    } catch (Exception ex) {
        throw new RuntimeException(ex);
    }
    return randomName;
}