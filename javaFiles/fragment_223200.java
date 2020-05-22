String userHomeFolder = System.getProperty("user.home");
File textFile = new File(userHomeFolder, "mytext.txt");
BufferedWriter out = new BufferedWriter(new FileWriter(textFile));
try {
    ...
} finally {
   out.close();
}