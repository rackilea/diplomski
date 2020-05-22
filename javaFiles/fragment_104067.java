public class Diamond {
  public static void main(String[] args) {
    // 1st Half of Diamond

    // Creates Lines
    for (int i = 1; i <= 3; i++) {
      if (i == 1) {
        System.out.print("+");
        for (int h = 1; h <= 8; h++) {
          System.out.print("-");
        }
        System.out.print("+" + "\n");

      }
      System.out.print("|");
      // Nested Loop Creates Spaces Left Side
      for (int j = 4; j > i; j--) {
        System.out.print(" ");
      }
      System.out.print("/");

      // Nested Loop Creates Values Inside
      for (int j = 1; j < i; j++) {

        if (i % 2 == 0) {
          System.out.print("--");
        } else if (i == 1) {
          System.out.print("\\");
        } else {
          System.out.print("==");
        }

      }
      System.out.print("\\");
      // Nested Loop Creates Spaces Right Side
      for (int j = 4; j > i; j--) {

        System.out.print(" ");

      }
      System.out.print("|");

      System.out.print("\n");

    }
    // Midpoint of Diamond
    System.out.print("|<------>|" + "\n");

    // 2nd Half of Diamond

    // Creates Lines
    for (int i = 1; i <= 3; i++) {

      System.out.print("|");

      // Nested Loop Creates Spaces Left Side
      for (int j = 1; j <= i; j++) {

        System.out.print(" ");
      }
      System.out.print("\\");

      // Nested Loop Creates Values Inside
      for (int j = 1; j <= i; j++) {



        if (i == 2) {

          System.out.print("-");

        } else if (i == 1) {

          System.out.print("====");

        } else {

          System.out.print("");
        }

      }
      System.out.print("/");

      // Nested Loop Creates Spaces Right Side
      for (int j = 0; j < i; j++) {
        System.out.print(" ");
      }
      System.out.println("|");

    }
    System.out.print("+");
    for (int h = 1; h <= 8; h++) {
      System.out.print("-");
    }
    System.out.print("+" + "\n");
  }

}