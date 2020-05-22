import java.util.LinkedList;

public class run {
  public static void main(String[] argv) {
    System.loadLibrary("test");
    LinkedList<Killable> list = new LinkedList<Killable>();
    Lion l = new Lion();
    l.moo();
    Killable k = l.toKillable();
    list.add(k);
    k.die();
  }
}