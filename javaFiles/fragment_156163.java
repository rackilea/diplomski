public class Inheritance {
        public static class A<T,U,V>{
             T t;
             U u;
             V v;

             A(T t, U u, V v) {
                this.t = t;
                this.u = u;
                this.v = v;
            }

            T getT() {return t;}
            U getU() {return u;}
            V getV() {return v;}
        }

        public static class B<T,U,V> extends A<T,U,T>{
            public B(T t, U u, V v) {
                super(t, u ,t);
            }
        }

        public static void main(String[] args) {
            B<Boolean, Integer, String> b = new B<>(false, 1, "string");
           // 't' attribute is Boolean 
           // since type parameter T of class B is Boolean
           Boolean t = b.getT(); 
           // 'v' attribute is Boolean 
           // since type parameters T and V of class A must have the same type as 
           // type parameter T of class B 
           Boolean v = b.getV(); 
        }
    }