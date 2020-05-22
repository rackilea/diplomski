final int step = 3;

for (int s = 0; s < 50; s += step * 2) {

    System.out.println("Even number");
    for (int i = 0; i < step; i++) {
        System.out.println(s + i * 2);
    }
    System.out.println("Odd number");
    for (int i = 0; i < step; i++) {
        System.out.println(s + i * 2 + 1);
    }
}