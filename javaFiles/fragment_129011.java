public static void main(String[] args) {
    int length, rotate, i, x;
    Scanner scan = new Scanner(System.in);
    String s;
    // don't input the length of the array, let it tell you what its length is
    //length = Integer.parseInt(scan.nextLine());
    s = scan.nextLine();
    // make sure you really enter a pure integer here, to avoid a crash
    rotate = Integer.parseInt(scan.nextLine());
    char c[] = s.toCharArray();
    for (i=0; i < c.length; i++) {
        x = c[i];
        int base;
        if (x >= 65 && x <= 90) {
            base = 65;
        }
        else if (x >= 97 && x <= 122) {
            base = 97;
        }
        else {
            continue;
        }
        int diff = x - base;
        x = base + (rotate + diff) % 26;
        c[i] = (char)x;
    }
    System.out.println();
    for (i=0; i < c.length; i++) 
        System.out.print(c[i]);
}