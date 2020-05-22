public static void main(String[] args) {
    int x = 0, y = 0;
    System.out.println("Grading of employee");
    tryagain tryagain = new tryagain();
    Scanner i = new Scanner(System.in);
    System.out.println("Please enter salary\n");
    x = i.nextInt();
    System.out.println("Please enter merits\n");
    y = i.nextInt();
    employee sc = tryagain.new employee(x, y);
    sc.grade();
}