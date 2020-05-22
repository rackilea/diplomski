int number = 24;

for (int i=2; i < (int)Math.ceil(Math.sqrt(number)); ++i) {
    for (int j=i; j <= number / 2; ++j) {
        int pair = i * j;
        if (pair <= number) {
            System.out.println(pair + " = " + i + " x " + j);
        }
    }
}