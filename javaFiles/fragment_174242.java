public class IterableClass implements Iterable<LinkedList<Object>>{
    LinkedList<LinkedList <Object>> l = new LinkedList<LinkedList<Object>>();


    public IterableClass() {
        super();
        LinkedList<Object> a = new LinkedList<Object>();
        a.add("a1");
        a.add("a2");
        LinkedList<Object> b = new LinkedList<Object>();
        b.add("b1");
        b.add("b2");
        l.add(a);
        l.add(b);
    }

    public static void main(String[] args) {
        IterableClass iterableObject = new IterableClass();
        for(Iterator<LinkedList<Object>> it = iterableObject.iterator(); it.hasNext(); ) {
            LinkedList<Object> list = it.next();
            for (Iterator<Object> iterator = list.iterator(); iterator.hasNext();) {
                Object object = iterator.next();
                System.out.println(object);
            }
        }
    }

    @Override
    public Iterator<LinkedList<Object>> iterator() {
        return l.iterator();
    }

}