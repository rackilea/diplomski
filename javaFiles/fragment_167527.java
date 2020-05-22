public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter number of students: ");
    int n = sc.nextInt();
    sc.nextLine();                         // <----- observe this
    String name[] = new String[n];
    int totalmarks[] = new int[n];
    for (int i = 0; i < n; i++) {
        System.out.println("Student " + (i + 1));
        System.out.print("Enter name: ");
        name[i] = sc.nextLine();
        System.out.print("Enter marks: ");
        totalmarks[i] = sc.nextInt();
        sc.nextLine();                     // <----- observe this  
    }
    int sum = 0;
    for (int i = 0; i < n; i++) {
        sum = sum + totalmarks[i];
    }
    double average = (double) sum / n;
    System.out.println("Average is " + average);
    for (int i = 0; i < n; i++) {
        double deviation = totalmarks[i] - average;
        System.out.println("Deviation of " + name[i] + " is " + deviation);
    }
}