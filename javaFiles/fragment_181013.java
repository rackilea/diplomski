public class Main
{
    static class GenericCheck<X>{
        private X x;
        GenericCheck(X t){ // *** Use `X` directly
            x=t;
            System.out.println(t);
        }
        public void display(){
            System.out.println(x);
        }
    }
    public static void main(String[] args) {
        GenericCheck<String> genericCheck = new GenericCheck<>("sathish worked");
        // Need to provide generic here too ----------------^^  That shorthand form is fine

    }
}