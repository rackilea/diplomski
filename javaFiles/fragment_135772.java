public class Example {
   public String  first;         // visible -> maps to <first>
   private String second;        
   private String third;         
   private boolean fourth;       
   public String getSecond() {   // visible -> maps to <second>
      return second;
   }
   public vois setSecond(String s) 
      second = s;
   }
   public String getSecondBis() {   // visible -> maps to <secondBis>
      return third;
   }
   public vois setSecondBis(String s) 
      third = s;
   }
   public boolean isFourth() {   // visible -> maps to <fourth>
      return fourth;
   }
   public vois setFourth(boolean b) 
      fourth = b;
   }
   public String getFirst() {   // invalid!!! getFirst clashes with public first
      return first;
   }
   public vois setFirst(String s) 
      first = s;
   }
}