Scanner s = new Scanner(System.in);
String text = s.nextLine();//read input from user
File f = new File("C:\\Users\\itama\\Desktop\\filename.txt");
try {
    FileWriter fw = new FileWriter(f);
    fw.write(text);
    fw.flush();
    fw.close();
} catch (IOException e) {
    e.printStackTrace();
}