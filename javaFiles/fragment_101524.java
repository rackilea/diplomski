int NUMBERS = 100;
int RANDOMMAX = 99;
int tableOutput[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
for (int i = 0; i < NUMBERS; i++) {
    int temp = (int) (Math.random() * RANDOMMAX) + 1;
    tableOutput[temp % 10]++;
}
for (int i = 1; i <= 10; i++) {
    System.out.print(i + " - " + i * 10 + "| ");
    for (int j = 0; j < tableOutput[i-1]; j++) {
        System.out.print("*");
    }
    System.out.println();
}