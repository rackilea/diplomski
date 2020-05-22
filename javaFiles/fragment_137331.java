String path = new File("src/mock_test_data/MyFile.txt").getAbsolutePath();
 File file = new File(path);
 FileInputStream fis = new FileInputStream(file);
 byte[] data = new byte[(int) file.length()];
 fis.read(data);
 fis.close();
 content = new String(data, "UTF-8");