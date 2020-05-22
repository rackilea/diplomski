import java.util.Arrays;

public class ReDistribution {

  public static void main(String[] args) {
    int[] distribution = {100, 80, 50, 20, 0};
    System.out.println(Arrays.toString(reDistribute(distribution)));
    // prints: [0, 20, 0, 0, 50, 0, 0, 80, 0, 100]
  }

 /**
  * Assuming source array contains only integers in range [0, 100], redistributes into array
  * index       0,        1,        2,        3,        4,        5,        6,       7,         8,        9
  * range [0, 10], [11, 20], [21, 30], [31, 40], [41, 50], [51, 60], [61, 70], [71, 80], [81, 90], [91, 100]
  */
  private static int[] reDistribute(int[] source) {
    int[] target = new int[10];
    for (int num : source) {
      target[(num - 1) / 10] = num;
    }
    return target;
  }
}