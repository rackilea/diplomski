public class Class {
  private static final String[] profaneWords = {
    "cat",
    "dog",
    "llama"
  };

  public static void main(String... args) {
    System.out.println(isProfane("this is some user input."));
    System.out.println(isProfane("this is some user input containing the dirty word 'Cat'."));
    System.out.println(isProfane(" cat "));
    System.out.println(isProfane("Cat"));
  }

  private static boolean isProfane(final String input) {
    for (final String profanity : profaneWords) {
      if (input.toLowerCase().contains(profanity)) {
        return true;
      }
    }
    return false;
  }
}