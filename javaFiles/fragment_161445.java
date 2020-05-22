public class Test {

      public static void main(String[] args) {
          int LENGTH = 1000000;
          List<Integer> list = new ArrayList<>();
          for (int i = 0; i < LENGTH; i++) {
              list.add((int) (100 * Math.random()));
          }

          // start timing
          int sum = 0;
          for (int i = 0; i < LENGTH; i++) {
             sum += list.get(i);
          }
          // stop timing and report
      }
  }