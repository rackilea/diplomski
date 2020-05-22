public class FastContainsList<T> extends AbstractSequentialList<T> implements RandomAccess{
//extending sequential because it bases itself of the ListIterator(int) and size() implementation

    private List<T> list=new ArrayList<T>();
    private Set<T> set=new HashSet<T>();


    public int size(){
        return list.size();
    }

    public boolean contains(Object o){//what it's about
        return set.contains(o);
    }

    public ListIterator<T> listIterator(int i){
        return new ConIterator(list.listIterator(i));
    }

    /*for iterator()*/
    private ConIterator implements ListIterator<T>{

        T obj;
        ListIterator<T> it;

        private ConIterator(ListIterator<T> it){
        this.it = it
        }

        public T next(){
        return obj=it.next();
        }

        public T previous(){
        return obj=it.previous();
        }

        public void remove(){
        it.remove();//remove from both
        set.remove(obj);
        }

        public void set(T t){
            it.set(t);
            set.remove(obj);
            set.add(obj=t);
        }

         public void add(T t){
             it.add(t);
             set.add(t);
         }

        //hasNext and hasPrevious + indexes still to be forwarded to it
    }

}