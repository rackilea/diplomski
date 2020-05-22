public class OrderWording {
    public static void main(String[] args) {
       System.out.println(isAscendingOrdered("effort")); //true
       System.out.println(isAscendingOrdered("java")); //false
       System.out.println(isDescendingOrdered("Yea")); //true
    }

    public static boolean isAscendingOrdered (String s) {
       s=s.toUpperCase();
       for (int i = 0; i < s.length()-1; i ++) {
          if (s.charAt(i)>s.charAt(i+1))
              return false;                
       }
       return true;
    }

    public static boolean isDescendingOrdered (String s) {
       s=s.toUpperCase();
       for (int i = 0; i < s.length()-1; i ++) {
          if (s.charAt(i)<s.charAt(i+1))
              return false;       
       }
       return true;
    }
}