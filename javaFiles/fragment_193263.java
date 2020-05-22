public class Main {

    public static void main(String[] argv)
    throws Exception
    {
        Main x = new Main();
        x.process(new ArrayList<String>());
        x.process(new LinkedList<String>());
    }

    public <T,L extends List<T> & RandomAccess> void process(L  list) {

    }
}