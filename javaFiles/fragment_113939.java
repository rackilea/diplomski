public class Test{
  public static void main(String[] args){
    try {
      File inputFile = new File("pa2Data.txt");
      File outputFile = new File("pa2output.txt");
      Scanner fileIn = new Scanner(inputFile);
      BufferedWriter fout = new BufferedWriter(new FileWriter(outputFile));

      while(fileIn.hasNext()){
        String theLine = fileIn.next();
        fout.write("Infix expression: " + theLine + '\n');
      }
      fileIn.close();
      fout.close();
   } catch(Exception e){
      e.printStackTrace();
   }
 }