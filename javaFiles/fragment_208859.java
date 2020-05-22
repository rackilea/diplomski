public class BIT {

  // AddAtPosition: adds at binary indexed tree [bit] the value [v]
  // exactly at position [i]. The binary indexed tree has size [size]

  public static void AddAtPosition(int [] bit, int size, int i, int v) {
    while(i < size) {
      bit[i] += v;
      i += (i & -i);
    }
  }

  // AddAtInterval: adds at binary indexed tree [bit] the value [v]
  // to all position from [lo] to [hi]. The binary indexed tree has size [size]

  public static void AddAtInterval(int [] bit, int size, int lo, int hi, int v) {
    AddAtPosition(bit, size, lo+1, v);
    AddAtPosition(bit, size, hi+2, -v);
  }

  // QueryAtPosition: returns the value of index [i] at binary indexed tree [bit]

  public static int QueryAtPosition(int [] bit, int i) {
    int ans = 0;
    i++;
    while(i > 0) {
      ans += bit[i];
      i -= (i & -i);
    }
    return ans;
  }

  public static void main(String [] args) {
    int [] bit = new int[10+1]; // for values from 0-9
    AddAtInterval(bit, 11, 0, 5, 1);
    AddAtInterval(bit, 11, 4, 7, 1);
    for(int i=0; i<=9; ++i) {
      System.out.print("Query At position " + i + ": ");
      System.out.println(QueryAtPosition(bit, i));
    }
  }
}