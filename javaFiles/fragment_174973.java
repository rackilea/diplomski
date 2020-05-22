class Main {

public static int sum(int[] tab){
    int sum_total = 0;
    for(int i=0;i<tab.length;i++){
      sum_total += tab[i];
    }
    return sum_total;
}

public static int numberOdd(int[] tab){
    int n = 0;
    for(int i=0;i<tab.length;i++){
      if(tab[i] % 2 != 0){
        n++;
      }
    }
    return n;
}

public static int sumOdd(int[] tab){
    int n = 0;
    for(int i=0;i<tab.length;i++){
      if(tab[i] % 2 != 0){
        n+=tab[i];
      }
    }
    return n;
}

public static float average(int[] tab){
      return (float) sum(tab) / tab.length;

}
  public static void main(String[] args) {
    int[] array1 = {1,3,4,2};
    System.out.println(sumOdd(array1)/numberOdd(array1));
  }
}