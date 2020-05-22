import java.lang.Override;
public class A <ListType extends Comparable<ListType>>{
    ListType lt;
    A(ListType b){
        this.lt = b;
    }
    static class B implements Comparable<B>{
        B(){};
        @Override
        public int compareTo(B b){
            return 0;
        }
    }
    static class C implements Comparable<B>{
        C(){};
        @Override
        public int compareTo(B c){
            return 0;
        }
    }


    public static void main(String[] args){
        A<B> a = new A<B>(new B());   //OK
        A<C> _a = new A<C>(new C()); //ERROR: is not within bound
        System.out.println("");
    }
}