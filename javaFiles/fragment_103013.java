public static void main(String[] args) {

    short value = (short)0b1111111111100000;
    System.out.println(value); //-32, which is the given number
    int result = value >>> 5;
    System.out.println(result); //134217727, which is 00000111111111111111111111111111

  }