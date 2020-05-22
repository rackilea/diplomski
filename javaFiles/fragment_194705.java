public class Main{

  static class Boom {
    Boom(boolean noBoom) {
    }
    Boom() {
       throw new RuntimeException();
    }
  }

  public static void main(String[] args){
   Boom boom1 = new Boom(true);
   try {
     boom1=null;
     boom1=new Boom();
   } catch (Exception ex) {};
   System.out.println(boom1);

   Boom boom2 = new Boom(true);
   try {
     boom2=new Boom();
   } catch (Exception ex) {};
   System.out.println(boom2);

 }
}