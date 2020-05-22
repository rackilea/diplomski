public enum MyEnum {
   ONE(1),
   TWO(1, 2);
   private int value1, value2;

   private MyEnum(int value) {
      this.value1 = value;
      this.value2 = 0; // default
      // this.value2 = getFromSomewhereElse(); // get it at runtime
   }

   private MyEnum(int value1, int value2) {
      this.value1 = value1;
      this.value2 = value2;
   }

   public int getValue1() {
      return this.value1;
   }

   public int getValue2() {
      return this.value2;
   }
}