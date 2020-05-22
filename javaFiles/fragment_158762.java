enum MyEnum {
    foo(true, 5),
    bar(20, 50);

    private boolean bool;
    private int num1;
    private int num2;

    MyEnum(boolean bool, int num) {
      this.bool = bool;
      this.num1 = num;
    }

    MyEnum(int num1, int num2) {
      this.num1 = num1;
      this.num2 = num2;
    }
  }