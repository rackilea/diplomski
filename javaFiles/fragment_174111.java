// "Pretty print" 2D array
System.out.print("[");
for (int i = 0; i < bArray.length; i++) {
    System.out.print("[");
    for (int j = 0; j < bArray[i].length; j++) {
        System.out.print(bArray[i][j] + ((j < bArray[i].length - 1) ? ", " : ""));
    }
    System.out.print("]" + ((i < bArray.length - 1) ? ", " : ""));
}
System.out.println("]");