final File parentDir = new File("crawl_html");
parentDir.mkdir();
final String hash = "abc";
final String fileName = hash + ".txt";
final File file = new File(parentDir, fileName);
file.createNewFile(); // Creates file crawl_html/abc.txt