public static void main(String[] args) {
    int smallest = 0;
    int large = 0;
    int num;
    System.out.println("enter the number");//how many number you want to enter
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    num = input.nextInt();
    smallest = num; //assume first entered number as small one
    // i starts from 2 because we already took one num value
    for (int i = 2; i < n; i++) {
        num = input.nextInt();
        //comparing each time entered number with large one
        if (num > large) {
            large = num;
        }
        //comparing each time entered number with smallest one
        if (num < smallest) {
            smallest = num;
        }
    }
    System.out.println("the largest is:" + large);
    System.out.println("Smallest no is : " + smallest);
}