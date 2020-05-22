class Base<E> {
    E e;

    protected class BaseInner<I extends E>{
        E e() { return e; }
    } 
} 

class StrangeSub extends Base<Integer> {
    protected class StrangeSubInner extends Base<String>.BaseInner<String> {}
}