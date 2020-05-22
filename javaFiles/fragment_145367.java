public class Pair<T, U>{
    T First;
    U Second;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Pair<?, ?> pair = (Pair<?, ?>) o;

        if (First != null ? !First.equals(pair.First) : pair.First != null) {
            return false;
        }
        return !(Second != null ? !Second.equals(pair.Second) : pair.Second != null);

    }

    @Override
    public int hashCode() {
        int result = First != null ? First.hashCode() : 0;
        result = 31 * result + (Second != null ? Second.hashCode() : 0);
        return result;
    }
}