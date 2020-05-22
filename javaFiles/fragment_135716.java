class Heap<E extends Comparable>  implements java.lang.Cloneable{

    private java.util.ArrayList<E> list = new java.util.ArrayList<E>();
    Class<E> classE;

    public Heap(E[] objects) {
        Class<? extends Object[]> aClass = objects.getClass();
        this.classE = (Class<E>) aClass.getComponentType();
        for (int i = 0; i < objects.length; i++) {
            add(objects[i]);
        }
    }

    private  void add(E newObject){
        ...
    }

    @Override
    protected Heap<E> clone() {
        return new Heap<E>(list.toArray((E[])Array.newInstance(classE, list.size())));
    }
}