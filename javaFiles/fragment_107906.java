public abstract class A<T extends OutputType> {
    public abstract void display(ArrayList<T> results);     
}

public class B extends A<RDOutput> {
    public void display(ArrayList<RDOutput> results) {}     
}