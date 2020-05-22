public class Expr implements Comparable {
  ...
  public int compareTo(Object o) {
    if(this.total_apparitions > ((Expr) o).total_apparitions)
      return 1;
    else if(this.total_apparitions < ((Expr) o).total_apparitions)
      return -1;
    return 0;
  }
}