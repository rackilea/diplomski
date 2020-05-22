public class SecondClass implements Comparable<SecondClass> {
    private int value;

    public int compareTo(SecondClass other) {
        return this.value - other.value;
    }

    public boolean equals(Object other) {
        (if other == null || !(other instanceof SecondClass)) 
            return false;
        else
            return this.value == ((SecondClass) other).value;
    }

    public int hashCode() {
        return value;
    }
}