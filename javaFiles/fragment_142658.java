public class Test1 {
  private String txtFile; //the scope of this variable is the instance, i.e. it exists as long as the instance of Test1 exists.

  public void Passingvalue (){
    Scanner Scan = new Scanner(System.in);
    System.out.println("File Name ? ");
    txtFile = Scan.next();
  }

  public void myMethod(){
    System.out.print("Scan this file" + txtFile);
  }
}