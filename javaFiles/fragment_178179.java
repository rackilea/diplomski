float[] array = new float[3];
Scanner input = new Scanner(System.in);
for (int i = 0; i<array.length;i++) {
    System.out.print("Give me a value: ");
    if (input.hasNextFloat()) {
        array[i] = input.nextFloat();
    } else {
        System.out.print(input.next() + " is not an acceptable type. ");
        i--;
    }
}