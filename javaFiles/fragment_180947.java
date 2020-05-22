abstract class A<T> {

    public abstract void setList(ArrayList<? extends T> l);
}

class B extends A<Integer> {

    @Override
    public void setList(ArrayList<? extends Integer> l) {

        //...
    };
}