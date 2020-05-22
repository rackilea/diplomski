@Override
    public void run() {
        for (int i = 0; i < index + 100; i++) {
            sum += i;
        }
        System.out.println(sumThread.getSum()); //check the sum
    }