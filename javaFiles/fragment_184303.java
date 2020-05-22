import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

class IteratorFlattener<E> implements Iterator<E> {
    private Iterator<Iterator<E>> root;
    private Iterator<E> sub;
    public IteratorFlattener(Iterator<Iterator<E>> root) {
        this.root = root;
        if(root.hasNext()){
            this.sub = root.next();
        }
    }

    @Override
    public boolean hasNext(){
        if(sub != null){
            if(sub.hasNext()){
                return true;
            }
            if(root.hasNext()){
                sub = root.next();
                return sub.hasNext();
            }
        }
        return false;
    }


    @Override
    public E next(){
        if(sub == null){
            throw new NoSuchElementException("root iterator was empty");
        }
        return sub.next();
    }

    @Override
    public void remove(){
        if(sub == null){
            throw new NoSuchElementException("root iterator was empty");
        }
        sub.remove();
    }

    public static void main(String[] args){
        System.out.println("start to test traverse");
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        List<Integer> l2 = new ArrayList<>();
        l2.add(2);
        l2.add(3);
        List<Integer> l3 = new ArrayList<>();
        l3.add(4);
        l3.add(5);
        l3.add(6);
        List<Iterator<Integer>> root = new ArrayList<>();
        root.add(l1.iterator());
        root.add(l2.iterator());
        root.add(l3.iterator());
        IteratorFlattener it = new IteratorFlattener<>(root.iterator());
        while(it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println("start to test remove method");
        l1 = new ArrayList<>();
        l1.add(1);
        l2 = new ArrayList<>();
        l2.add(2);
        l2.add(3);
        l3 = new ArrayList<>();
        l3.add(4);
        l3.add(5);
        l3.add(6);
        root = new ArrayList<>();
        root.add(l1.iterator());
        root.add(l2.iterator());
        root.add(l3.iterator());
        int i = 0;
        it = new IteratorFlattener<>(root.iterator());
        while(it.hasNext() && i < 3){
            it.next();
            it.remove();
            i++;
        }
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}