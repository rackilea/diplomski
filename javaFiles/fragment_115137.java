public class HelloWorld {
  public static void main(String[] args) {

     int count = 10;
     int numb = 8;
     for (int x = 0; x < count; x++ ) {
     String buildPW = "";
     for (int y = 0; y < numb; y++ ) {

        String digits =      "0123456789abcdefghijkmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";                                                                         
        int index = (int)     (Math.random()*digits.length());
        buildPW += digits.substring(index, index+1);
      }     

   System.out.println(buildPW);
   }  


  }
}