public class SecondAPIClass implements MyInterface {

    private int dada = 0;

    public int setInt(int davs) { // note that you have to keep the same method signiture in all derived classes
        dada = davs + 5;
        return dada;
    }

    public int getInt() {
        return da;
    }
}