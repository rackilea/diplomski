public static short[] toShorts(String finalString) {
    String[] tabOfShortString = finalString.split(" ");
    int length = tabOfShortString.length;
    System.out.println("Length of float string is" + length);
    short[] shortsArray = new short[length];
    for (int l = 0; l < length; l++) {
        //System.out.println("l is currently "+l);
        Short res = new Short(tabOfShortString[l]);
        System.out.println("Indice Short Value is " + res);
        shortsArray[l] = res;
    }

    return shortsArray;

}