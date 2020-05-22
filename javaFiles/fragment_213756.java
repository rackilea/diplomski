public static void main(String[] args) {
    String input = "John},{Doe},{Anna";
    String[] parts = input.split("},\\{"); // '\\{' does the trick

    for (String part : parts){
      System.out.println(part);
    }
  }