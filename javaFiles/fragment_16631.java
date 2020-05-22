@SuppressWarnings("rawtypes")
public class General<Key extends Comparable<Key>> {
    private Comparable[] keys;

    public General(int NMAX) {
        keys = new Comparable[NMAX];
    }

    public void set(int ind, Key k) {
        keys[ind] = k;
    }

    @SuppressWarnings("unchecked")
    public Key get(int ind) {
        return (Key)keys[ind];
    }
}