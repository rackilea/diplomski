File file = new File("abc.csv");
    FileInputStream fis = null;
    fis = new FileInputStream(file);
    byte[] data = new byte[(int) file.length()];
    fis.read(data);
    fis.close();
    String str = new String(data, "UTF-8");