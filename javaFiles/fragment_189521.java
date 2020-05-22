class OneAdder implements Adder { 
    int add(int x) {
        return x+1;
    }
}

class Example {

    void run() {
        OneAdder a1 = new OneAdder();
        int result = compute(a1);
        System.out.println(result);
    }

    private int compute(Adder a) {
        int sum = 0;
        for (int i=0; i<100; i++) {
            sum = a.add(sum);
        }
        return sum;
    }
}