import java.util.Arrays;

public class Class {
  private static final String[] profaneWords = {
    "cat",
    "dog",
    "llama"
  };

  private static boolean isProfane(final String input) {
    return Arrays.stream(profaneWords)
      .anyMatch(input.toLowerCase()::contains);
  }
}