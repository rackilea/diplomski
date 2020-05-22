$ cat myProgram.java 
public class myProgram{

   public static boolean getRandomBoolean() {
       return Math.random() < 0.5;
       //I tried another approaches here, still the same result
   }

   public static void main(String[] args) {
       System.out.println(getRandomBoolean());  
   }
}

$ javac myProgram.java
$ java myProgram ; java myProgram; java myProgram; java myProgram
true
false
false
true