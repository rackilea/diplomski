public class UserVariable<T extends Comparable<T>> implements Comparable<UserVariable<T>> {
    private T myValue;

    public void setValue(T value) {
        myValue = value;
    }

    public T getValue() {
        return myValue;
    }

    public int compareTo(UserVariable<T> rhs) {
        return getValue().compareTo(rhs.getValue());

    }

    public static void main(String[] args) {
        UserVariable<Integer> newVar = new UserVariable<Integer>();
        newVar.setValue(new Integer(20));
    }
}