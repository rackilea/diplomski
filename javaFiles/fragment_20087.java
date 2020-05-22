Scanner reader = new Scanner(System.in);
int sum = 0;
int many = 0;
double average = 0;
int even = 0;
int odd = 0;

do {
    System.out.println("Type numbers: ");
    number = Integer.parseInt(reader.nextLine());
    if (number == -1)
        break;
    sum = sum + number;
    many++;
    average = (double)sum / many;
    if (number%2 == 0) {
        even++;
    } else {
        odd++;
    }
} while (true);