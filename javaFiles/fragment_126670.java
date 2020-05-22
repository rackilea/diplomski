public class Main {
  public static void perms(int[] arr, int i) {
    if (i == arr.length) {
      for (int j=0; j<arr.length; j++)
        System.out.print(arr[j] + " ");
      System.out.println();
      return;
    }

    for (int j=i; j<arr.length; j++) {
      for (int k=0; k<=9; k++) {
        arr[j] = k;
        perms(arr, j+1);
      }

      // if arr = {9, 9}, break;
      // this cannot put above the inner loop, I will 
      // leave that for you to think why
      if(arr[0] == 9 && arr[1] == 9){
        return;
      }
    }
  }

  public static void main(String[] args) {
    perms(new int[]{0,0}, 0);
  }
}