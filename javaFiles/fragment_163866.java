String[] keys = new String[2];  // Since you are reading 2 keys, so size = 2
boolean redo = false;
int count = 0;    // To maintain the number of keys read. should stop at count = 2

do {

    redo = false;
    Scanner keycode =  new Scanner(System.in);

    System.out.println("Input keycode No: + " + (count + 1));
    String key1 = keycode.nextLine();

    if (key1.length() < 6 || key1.length() > 8) {
        redo = true;

    } else {
        /** Your remaining code **/

        if (!upper) {
            System.out.println("must contain at least one uppercase character");
            redo = true;

        } else if (!lower) {
            System.out.println("must contain at least one lowercase character");
            redo = true;

        } else if (!number) {
            System.out.println("must contain at least one number");
            redo = true;

        } else {
            keys[count++] = key1;  // Enter a new key in array
        }
    }

} while (redo || count < 2);  

if (keys[0].equals(keys[1])) {
    System.out.println("Keys are equal");
}