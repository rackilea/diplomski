public class UserVariable<T extends Comparable<T>> implements Comparable<T> {

    @Override
    public int compareTo(T o) {
        // TODO Auto-generated method stub
        return 0;
    }

    private T myValue;

    public void setValue(T value){
        myValue = value;
    }

    public static void main(String[] args) {
        UserVariable<Integer> newVar = new UserVariable<Integer>();
        newVar.setValue(new Integer(20));
    }
}