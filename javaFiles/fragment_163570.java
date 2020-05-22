Scanner scanner = new Scanner(System.in);
int[] largest = new int[3];

while (scanner.hasNext()) {
    int number = scanner.nextInt();
    scanner.nextLine();
    if (number == 0) {
        break;
    }
    if (number > largest[0]) {
        largest[0] = number;
    }
    Arrays.sort(largest);
    System.out.println(Arrays.toString(largest));
    System.out.println(largest[0]);
}
scanner.close();
System.out.println("Third largest " + largest[0]);