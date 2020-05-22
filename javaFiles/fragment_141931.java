System.out.println(Integer.toBinaryString(256));
    int numberBits = (int) Math.ceil(Math.log(256) / Math.log(2)) + 1;
    int numberBytes = (int) (Math.ceil(Math.log(256) / Math.log(2)) / 8) + 1;
    System.out.println(numberBits);
    System.out.println(numberBytes);

100000000
9
2