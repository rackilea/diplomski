public class Main {
    public static void main(String[] args) {
        int count = 0;
        for (Secret dir : Secret.values()) {
            if (dir.name().startsWith("STAR"))
            {
                count += 1;
            }
        }
        System.out.println(count);
    }
}


/// At least two constants start with STAR
enum Secret {
  STAR, CRASH, START // ...
}