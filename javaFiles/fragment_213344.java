public class testing1 {

  public static void main(String[] args){
    int [] x = {2, 2, 5, 5, 5, 1, 7, 7, 5, 7};
    System.out.println(isGrouped(x));
  }

  public static boolean isGrouped(int[] x){

      int prev = x[0] ;

    Hashtable<Integer, Integer> hashtable = 
              new Hashtable<Integer, Integer>();
    hashtable.put(x[0], 0);
    for (int i = 1 ; i < x.length ; i ++)
    {
        if (hashtable.get(x[i]) != null && prev == x[i]){
            hashtable.put(x[i], hashtable.get(x[i]) + 1);
        }

        else if (hashtable.get(x[i]) != null && prev != x[i]){
            return false;
        }

        else{
            hashtable.put(x[i], 0);
        }
        prev = x[i];
    }
    return true ;
    }

}