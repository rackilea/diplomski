/**
 * Print List
**/
public static void main (String[] args) {
    /* Initialize Number Value */
    int num = 0;
    /* Initialize Increment Value */
    int increment = 10;
    /* Print First Number */
    System.out.println(num);
    for(int i = 0; i < 10; i++) {
        /* Increment Number */
        num += increment;
        /* Print Next Number In List */
        System.out.println(num);
        /* Increment The Increment Counter */
        ++increment;
    }
}