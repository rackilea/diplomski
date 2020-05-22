Properties prop = new Properties();
Properties prop2 = new Properties();

InputStream is = new FileInputStream("file1");      
InputStream is2 = new FileInputStream("file2");

StringBuilder fileData= convertToString(is2);
int start = fileData.indexOf("[groups]");
int end = fileData.indexOf("[", start + 8) + 1;

InputStream file2Section = new ByteArrayInputStream(fileData.substring(start, end).toString().getBytes());

prop.load(is);
prop2.load(file2Section);