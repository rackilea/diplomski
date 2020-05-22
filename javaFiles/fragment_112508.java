public class Dice {
  public static void main(String... args) {

    // First, ensure there are 2 args
    if (args.length != 2) {
      throw new IllegalArgumentException("Exactly 2 parameters required !");
    }

    int firstArgInt;
    int secondArgInt;

    // Verify all args are integers
    try {
      firstArg = Integer.parseIng(args[0]);
    } catch (NumberFormatException nbfe) {
      // 2 possible solutions : throw an exception, or assign a default value
      // - throw new IllegalArgumentException("First arg must be an integer");
      // - firstArg = 42;
    }
    try {
      secondArg = Integer.parseIng(args[1]);
    } catch (NumberFormatException nbfe) {
      // Same as above
    }

    // Etc.

  }
}