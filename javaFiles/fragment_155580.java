public class Pair<X,Y> {
  public final X x;
  public final Y y;

  public Pair(X x, Y y) {
    this.x = x; this.y = y;
  }
}

public static<X,Y> void sortTwoLists(List<X> xs, List<Y> ys, final Comparator<X> c) {
 if (xs.size() != ys.size()) 
   throw new RuntimeException("size mismatch");

 List<Pair<X,Y>> temp = new ArrayList<Pair<X,Y>>();

 for (int i = 0; i < xs.size(); ++i) 
   temp.add(new Pair<X,Y>(xs.get(i), ys.get(i)));

 Collections.sort(temp, new Comparator<Pair<X,Y>>() {
  @Override
  public int compare(Pair<X, Y> a, Pair<X, Y> b) {
    return c.compare(a.x, b.x);
  }
 });

 for(int i = 0; i < xs.size(); ++i) {
   xs.set(i, temp.get(i).x);
   ys.set(i, temp.get(i).y);
 }
}