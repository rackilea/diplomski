Scanner kb = new Scanner(System.in);
// c = continue
char c = 'a';
// attempt to limit the input to 3 times
int attempt = 3;
// option = op
int op = 0;

do {
    do{
        System.out.println("Choose continue[0] or go out[1].");
        while  (!kb.hasNextInt()) {
            kb.nextLine();
            System.out.println("It's not a number.");
        }
        op = kb.nextInt();
    } while ( op <= -1 || op >= 2 );

    switch (op) {
        case 0:
            System.out.println("Continue!");
            System.out.println("Do you wanna try again,"+attempt+" less?[c]+enter\n"
                    + "Any other key + enter to exit.");
            c = kb.next(".").toUpperCase().charAt(0);
            attempt--;
            break;
        case 1:
            attempt = -1;
            break;
        default:
            break;
    }
} while ( attempt > 0 && ( c == 'C' ) );
kb.close();