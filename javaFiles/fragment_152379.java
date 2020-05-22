boolean app_continue = true ;
while(app_continue){
 int ii = input.nextInt();

 switch (ii) {
    case (1):
        for (int number : a) {
            System.out.print(" " + number);
        }
        break;
    case (2):
        for (i = 0, j = a.length - 1; i < (a.length) / 2; i++, j--) {
            x = a[i];
            a[i] = a[j];
            a[j] = x;
        }
        for (int number : a) {
            System.out.print(" " + number);
        }
        break;
    case (3):
        app_continue = false ; // or System.exit(0) to terminate immediately;
        break;
    default: {
    }
 }
}