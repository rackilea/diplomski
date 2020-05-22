class one implements three.two{
   public void how(){
       System.out.println("\nHow! i = " + i);
       what();
   }

   public void what(){
       System.out.println("\nWhat! i = " + i);
   }

   public static void main(String args[]){
       three.two a = new one();
       a.what();
       one b = new one();//created this to call the how() method in one.java  
       b.how();
    }
}