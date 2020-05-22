public static void main(String[] args) {
    try{
        System.out.println(new Fibonacci().fibonacciGetal(92));
    }catch(FibonacciException e){
        System.out.println(e.getMessage());
    }
}