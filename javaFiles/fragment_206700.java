public static void main(String []args) throws Exception {
    Main m = new Main();
    Future<Integer> futureInt = m.calculate(5);
    // do some other asynchronous task or something in main thread while futureInt  is doing its calculations
    // and then call Future::get
    int result = futureInt.get();