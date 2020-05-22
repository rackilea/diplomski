public class GlobalKeyListener implements NativeKeyListener {
  ArrayList<Class1> arrayList1 = new ArrayList<>();
  public ArrayList<Class1> listing() {
      return arrayList1;
  }

  public void nativeKeyPressed(NativeKeyEvent e) {
    synchronized(this) {
      arrayList1.add(new Class1(e.getKeyCode(), 1));
      this.notifyAll();
    }
  }

  public void nativeKeyReleased(NativeKeyEvent e) {
    synchronized(this) {
      arrayList1.add(new Class1(e.getKeyCode(), 0));
      this.notifyAll();
    }
  }

  public void nativeKeyTyped(NativeKeyEvent e) {
  }
}