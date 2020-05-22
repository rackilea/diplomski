public class Singleton {
private static Singleton uniqInstance;
public ArrayList<Names> names = new ArrayList<Names>();;
private Singleton() {
}
public static Singleton getInstance() {
    if (uniqInstance == null) 
         uniqInstance = new Singleton();
    return uniqInstance;
}
public void setArrayList(ArrayList<Names> names)
 {
      this.names = names;

     }
 public ArrayList<Names> getArrayList()
 {
      return this.names;

     }
}