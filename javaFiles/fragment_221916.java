public class T {
  public static void main(String[] args) {
    int[] cdn = {1,1,1,1,1,1,2,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
    int[] cmn = {8,8,16};

    int numofints = 0;
    int init = 0;
    int m2 = 3;

    int j = 0;
    while(init < m2){
     int plus = 0;
     while(j < cdn.length){
        plus += cdn[j];
        j++;
        numofints++;
        if(plus == cmn[init]){
          init++;
          System.out.println(j);
          break;
        } 
      }
    if (j == cdn.length) break;
    }
  }
}