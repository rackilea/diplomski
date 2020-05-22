static void printDiamond(int size) {
    for (int i = 0; i < (int)Math.ceil(size/2.0); i++) {
        for (int a = 0; a < (int)Math.ceil(size/2.0) - (i + 1); a++) {
            System.out.print(" ");
        }
        System.out.print("X");
        for (int b = 0; b < (i * 2); b++) {
            System.out.print(" ");
        }
        System.out.print("X");
        System.out.println();
    }

    for (int i = (int)Math.floor(size/2.0)-1; i >= 0; i--) {
        for (int a = 0; a < (int)Math.ceil(size/2.0) - (i + 1); a++) {
            System.out.print(" ");
        }
        System.out.print("X");
        for (int b = 0; b < (i * 2); b++) {
            System.out.print(" ");
        }
        System.out.print("X");
        System.out.println();
    }
}

printDiamond(5);
System.out.print("\n");
printDiamond(6);