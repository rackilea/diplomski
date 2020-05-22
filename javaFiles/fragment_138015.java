public class APIClass implements MyInterface {

    private int da;

    public int setInt(int davs) {
       // return da; <- this doesn't make a whole lot of sense
       da = davs; // I assume you meant this
       return da; // usually you don't return anything from a setter
    }

    public int getInt() {
        return dada;
    }
}