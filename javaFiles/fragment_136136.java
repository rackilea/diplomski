abstract class RecursiveList {

    protected static int index = -1;
    protected static int[] elements = new int[]{ 5,2,1,4,3,2,6 };

    public static RecursiveList startRecursion() {
        return new Cons();
    }

    public abstract boolean empty();

    public abstract int count();

    public abstract Integer getElement();

    public static int incIndex() {
        return index += 1;
    }
}