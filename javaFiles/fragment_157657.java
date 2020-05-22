File fold = new File("../playlist/" + existingPlaylist.getText() + ".txt");
fold.delete();

File fnew = new File("../playlist/" + existingPlaylist.getText() + ".txt");

String source = textArea.getText();
System.out.println(source);

try {
    FileWriter f2 = new FileWriter(fnew, false);
    f2.write(source);
    f2.close();

} catch (IOException e) {
    e.printStackTrace();
}