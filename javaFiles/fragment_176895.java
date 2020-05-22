public void systemIO() throws java.io.IOException {
    System.out.println("Enter the character");
    i = System.in.read();
    System.out.println("the character Enter by the user : " + (char) i);
    System.out.println("the assci vlue " + i);
    System.in.skip(System.in.available());
}

public void cntApp() throws java.io.IOException {
    char cnt = 'y';
    while (cnt == 'y') {
        systemIO();
        System.out.println("press 'y'  if you want continue");
        cnt = (char) System.in.read();
        System.out.println("The Entery value   " + cnt);
        System.in.skip(System.in.available());
    }
}