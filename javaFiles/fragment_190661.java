public class Demo {

    public static class MyPojo {
        public int value;
        public MyPojo(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {

        MyPojo pojoOne = new MyPojo(1);
        MyPojo pojoTwo = new MyPojo(2);

        System.out.println(pojoOne.value);
        System.out.println(pojoTwo.value);

        pojoTwo = pojoOne; 
        // You now have two variables holding a reference to 
        // a single instance of MyPojo. Changes made through
        // either affect the same object. The object you 
        // originally instantiated and assigned to pojoTwo 
        // is no longer referenced by anything and will be 
        // garbage collected. 
        pojoOne.value = 3;
        System.out.println(pojoTwo.value); 

    }
}