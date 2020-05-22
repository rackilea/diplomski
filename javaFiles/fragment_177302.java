public class CoolDude {
  public static void main(String[] args) {
    for (int i = 100; i <= 500; i++)
      if (i % 5 == 0 || i % 11 == 0) // This is the condition where we decide to print something
        System.out.printf("%s%s- %d%n", i % 5 == 0 ? "Cool " : "", i % 11 == 0 ? "Dude " : "", i);
  }
}