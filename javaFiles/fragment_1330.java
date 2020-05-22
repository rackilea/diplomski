public class D<U1,U2> {
}

//Note the order of F3,F4.
class C<F1,F2,F3,F4> extends D<F4,F3>{

}

class Main{

    public static void main(String[] args) {

        C<Integer,String,Float,Number> obj = new C<>();

        D<Float ,Number> obj2 = obj; // Compilation error

        D<Number ,Float> obj3 = obj; //This is fine


    }
}