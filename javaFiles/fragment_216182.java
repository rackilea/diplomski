class E {

    public static void main(String[] args) {
        foo(new int[] { 1, 2, 3, 4, 5, 6 });
    }

    static void foo(int[] a) {
        int N = a.length;
        for(int i = 0; i < N; i++){
           if(a[0] + a[1] == 0){
              System.out.println("Foo");
           }
        }
    }
}