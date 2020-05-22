Scanner input = new Scanner(System.in);
int[] numbers = new int[10];
boolean[] uniques = new boolean[10];

for(int i = 0; i < 10; i++) {
    System.out.println("Please enter a value: \n" + "[" + (i + 1) + "]: ");
    numbers[i] = input.nextInt();
    uniques[i] = true;
    for(int j = 0; j < 10; j++) {
        if(numbers[i] == numbers[j] && i != j) {
            uniques[i] = false;
        }
    }
}

System.out.println("\nThe numbers you entered were: \n");
for(int i = 0; i < 10; i++) {
    System.out.println(numbers[i] + ", ");
}
System.out.println("done.\n\n");

System.out.println("\nThe uniqe numbers you entered were: \n");
for(int i = 0; i < 10; i++) {
    if(uniques[i]) {
        System.out.println(numbers[i] + ", ");
    }
}
System.out.println("done.\n\n");