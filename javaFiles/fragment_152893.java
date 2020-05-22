public class Tad {
  public static void main(String[] args) throws IOException {
    FileWriter dos = new FileWriter(new File("E:\\temp.txt"));
    for (int i = 0; i < 10; i++)
      dos.write(i+"");  
    dos.close();

  }
}