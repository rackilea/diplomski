abstract class Visitor<T> {
public void visit(T n) {
    try {
        this.getClass().getDeclaredMethod("doIt", n.getClass()).invoke(this, n);
    } catch (Exception ex) {
        doIt((T) n);
    }
}
public void doIt(T n) {
    System.out.println("doIt() for base " + n);
}
public Object getResult() {
    return null;
}