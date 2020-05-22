while (y != 1025) {

    for (int x = 0; x <= y; x++) {
        System.out.println("Decimal");
        System.out.println(x);
    }

    for (int i = 0; i <= y; i++) {
        System.out.println("");
        System.out.println("Binary");
        convertToBinary(i);
    }

    System.out.println("");

    for (int z = 0; z <= y; z++) {
        System.out.println("Hex");
        convertToHex(z);
    }

    System.out.println("");

    for (int d = 0; d <= y; d++) {
        System.out.println("Octal");
        convertToOctal(d);
        System.out.println("");
    }
    break;
}