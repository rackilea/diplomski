public class Tad {
  public static void main(String[] args) throws IOException {
    DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(
        new File("E:\\temp.txt"))));
    for (int i = 0; i < 10; i++){
       dos.writeChars(Integer.toString(i)); 
    }
    dos.close();

  }
}