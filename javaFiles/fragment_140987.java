public class MyClass {
    String[] arr;

    public MyClass (String[] a_arr) {
        arr = a_arr;
    }

    public class MyInner {
        public void MyMethod () {
            // I need to access 'my.arr' from here how can i do it. 
        }

    }

    public static void main (String[] args) {
        String[] n= {"ddd","f"};
        MyClass myClass = new MyClass (n);
    }
}