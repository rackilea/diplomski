class B<T extends Serializable> {

    A<T> myA = null;    

    void foo(T arg) {
        myA.bar(arg);
        myA.bar2(arg);
    }
}