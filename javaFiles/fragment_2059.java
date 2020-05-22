public class ReadLastTwoLine{

 public static void main(String[] args) throws Exception {

  FileInputStream in = new FileInputStream("file.txt");
  BufferedReader br = new BufferedReader(new InputStreamReader(in));

  String strLastLine = "";
  String tmp;
  String strlastLineMinusOne="";;

  while ((tmp = br.readLine()) != null)
  {
     strlastLineMinusOne = strLastLine;
     strLastLine = tmp;
  }

  System.out.println("Last Line Minus one is : "+strlastLineMinusOne");
  System.out.println("Last Line is : "+strLastLine");

  in.close();
 }
}