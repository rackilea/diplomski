public static String[] subName;//<---------------not initialize it here
static Scanner scan = new Scanner(System.in);

public static void main(String[] args) {

    System.out.println("Please Enter Subject No");
    subNo = scan.nextInt();
    subName = new String[subNo];//<------------------initialize it here
    System.out.println("Subject No Is : " + subNo);