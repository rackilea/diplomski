import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Main {

  static int[] data = {1,2,3,4,6,12};

  static class Pair {

    public Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public int x;
    public int y;

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Pair pair = (Pair) o;
      return
        x == pair.x && y == pair.y ||
        x == pair.y && y == pair.x;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x * y);
    }
  }

  public static void main(String[] args){

    HashMap<Integer, HashSet<Pair>> products = new HashMap<>();

    // index all pairs by product in o^2 loop
    for (int i=0;i<data.length;i++){
      for (int j=i+1;j<data.length;j++){
        int a = data[i];
        int b = data[j];
        Integer p = a*b;
        if (!products.containsKey(p)){
          products.put(p, new HashSet<>());
        }
        HashSet<Pair> knownPairs = products.get(p);
        Pair pair = new Pair(a, b);
        knownPairs.add(pair);
      }
    }

    // output results
    for (Integer product: products.keySet()) {
      System.out.print("product: "+product+" -");
      HashSet<Pair> pairs = products.get(product);
      for (Pair pair : pairs) {
        System.out.print(" "+pair.x+"x"+pair.y);
      }
      System.out.println();
    }


  }

}