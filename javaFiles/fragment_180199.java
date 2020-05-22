Calculation<MyInteger> calc = new Calculation<MyInteger>(
    new MyInteger(1), new MyInteger(2)) {
      public MyInteger valueOf(int i) {
        return new MyInteger(i);
      }
    });

Operations result = calc.sumPlusValue3();