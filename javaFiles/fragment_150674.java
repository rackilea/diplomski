public class MyList <E> extends AbstractList<E> {

    private Object[] list = new Object[10];
    private int size = 0;


    public E get(int i){
        if(i >= size) throw new IndexOutOfBoundsException("duh!");
        return (E)list[i];
    }

    public boolean add(E e){
        if(size >= list.length){
            Object[] newList = new Object[list.length + 10];
            System.arraycopy(list,0, newList, 0, list.length);
            list = newList;
        }
        list[size] = e;
        size++;
        return true;
    }

    public int size(){
        return size;
    }

    public static void main(String[] args){
        List<String> l = new MyList<String>();
        for(int i = 0; i < 100; i++){
            l.add(""+i);
        }
        System.out.println(l.size());
    }

}