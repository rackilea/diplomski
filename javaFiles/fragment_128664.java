public class main {
  public static void main(String[] args) {
    try {
      Runtime.getRuntime().exec("cmd /c proj1.jar");
      Runtime.getRuntime().exec("cmd /c proj2.jar");
    } catch(Exception exce){ 
      /*handle exception*/
    }
  }
}