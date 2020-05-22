int[] numbers = new int[1000];
ArrayList[] bins = new ArrayList[10];

void setup() {
    for(int i = 0; i<bins.length; i++) {
        bins[i] = new ArrayList();
    }

    for (int i = 0; i < numbers.length; i++) {
        numbers[i] = floor(random(0,100));
    }
}

void counter(int[] numbers, ArrayList[] bins) {
    for (int i = 0; i < numbers.length; i++) {
        bins[floor(float(numbers[i])/10.0)].add(numbers[i]);
    }
}