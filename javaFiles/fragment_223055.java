public enum Value{ VALUE_ONE(300), VALUE_TWO(501), UNKNOWN(-1);
   private int value;
   private Value(int value) {this.value = value;}

   public int getValue() {
     return value;
   }

   public Value findValue(int value) {
     for (Value v:values()) {
       if (v.value == value)
          return v;
     }
     return Value.UNKNOWN;
}