class Base {
}
class Derived extends Base {
}
public class Example
{
    static class GenericCheck<X>{
        private X x;
        GenericCheck(X t){
            x=t;
            System.out.println(t.getClass().getName());
        }
        public void display(){
            System.out.println(x);
        }
    }
    public static void main(String[] args) {
        GenericCheck<Base> genericCheck = new GenericCheck<>(new Derived());
    }
}