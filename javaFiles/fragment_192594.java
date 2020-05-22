double input = 43.0;
for (int i = 0; i <= 10; i++) {
    double output = input;
    if ((int) (input * 10) % 2 == 1) {
        output = ((double) (int) (input * 10) - 1) / 10;
    }
    System.out.printf("input:  %f   output: %f%n", input, output);
    input += 0.1;
}