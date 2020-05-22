static class MyRunnable<E extends Comparable<E>> implements Runnable {

    private Test<E> mytest;

    public MyRunnable(Test<E> test) {
        mytest = test;
        // TODO Auto-generated constructor stub
    }

    @Override
    public void run() {
        Test<Double> test = new Test<Double>();
        ArrayList<Double> doubles = test.arraylist.get();
        doubles.add(new Double(Math.random()));//No type cast needed
    }
    // TODO Auto-generated method stub

 }