public class Test15 {
  static int[] a = new int[]{1, 1, 1, 2, 3, 5, 3, 4, 5, 5};
  public static void main(String[] args){
    for (int i=0; i< a.length; i++) {
      boolean f = false;
      for (int j=i+1; j <a.length; j++)
        if (a[i]==a[j]) {
          System.out.println("duplicate ("+i+", "+j+")");
          f=true;
          break;
        }
      if (!f)
        System.out.println("unique ("+i+", "+a[i]+")");
    }
  }
}