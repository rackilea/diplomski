public class Main
{
    static class GenericCheck<X>{
        private X x;
        <T extends X> GenericCheck(T t){
        //^^^^^^^^^^
            x=t;
            System.out.println(t);
        }
        public void display(){
            System.out.println(x);
        }
    }
    public static void main(String[] args) {
        GenericCheck<String> genericCheck = new GenericCheck<>("sathish worked");
        // -------------------------------------------------^^

    }
}