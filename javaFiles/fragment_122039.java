public class Junk<T extends Junk> {
    T var;

    public void setT(T var) {
        this.var = var;
    }

    public T returnType(){
        return var;
    }
}