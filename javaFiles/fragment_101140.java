public class MultipleResult<T> {

    private ArrayList<T> resultA;
    private ArrayList<T> resultB;
    private ArrayList<T> resultC;
    private ArrayList<T> resultD;

    public MultipleResult(ArrayList<T> arrayA, ArrayList<T> arrayB) {
        resultA=arrayA;
        resultB=arrayB;
    }

    public MultipleResult(ArrayList<T> arrayA, ArrayList<T> arrayB,
                          ArrayList<T> arrayC, ArrayList<T> arrayD) {
        resultA=arrayA;
        resultB=arrayB;
        resultC=arrayC;
        resultD=arrayD;
    }

    public ArrayList<T> getResultA() {
        return resultA;
    }

    public ArrayList<T> getResultB() {
        return resultB;
    }

    public ArrayList<T> getResultC() {
        return resultC;
    }

    public ArrayList<T> getResultD() {
        return resultD;
    }
}