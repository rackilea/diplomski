AnonClass anon =
    new AnonClass(12) {
      {
        System.out.println(super.x); //Prints 12
        System.out.println(x); //prints 4
      }
    };