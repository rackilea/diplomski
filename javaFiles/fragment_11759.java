public class Main{
   public static void main(String []args) {
        User user1 = new Admin("Bill", 18, 2); 

        System.out.println("Hello "+user1.getName()); 
        user1.getLevel();
    }
}