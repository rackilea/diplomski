interface A {
    void first();
    default void second(){
       //throw new UnsupportedOperationException(); or do some default logic
    }
}