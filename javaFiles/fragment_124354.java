public class Super {
     String str = "I'm super!\n";

     public Super(String stringValue){
         this.str = stringValue;
     }

     public String toString() {
        return str;
     }
  }

  public class Sub extends Super {
     public Sub(){
       super("I'm sub.\n");
     }
  }

  public class TestFH {
    public static void main(String[] args) {
       Sub s1 = new Sub();
       System.out.printf(s1.toString());
    }
  }