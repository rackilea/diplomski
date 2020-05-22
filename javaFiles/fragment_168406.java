Scanner keyboard =  new Scanner(System.in);
int max = Integer.MIN_VALUE;
int min = Integer.MAX_VALUE;

int num;
boolean entered = false;
do {
    System.out.println("Enter a number ( press -99 to quit)");
    if ((num = keyboard.nextInt()) == -99) {
        if (!entered) {
            System.out.println("No numbers where entered"); 
        } 
        break;
    } 
    if (num > max) max = num;
    if (num < min) min = num;
    entered = true;
} while (num != -99);

if (entered) {
    System.out.println("the largest number: "+max);
    System.out.println("the smallest number: "+min); 
}