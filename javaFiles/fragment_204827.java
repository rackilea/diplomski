public static void main(String[] args) {
    System.out.println("Problem 9 tests");
    int[] arr7 = {300, 400, 500};
    System.out.println(Arrays.toString(highDef(arr7)));
    System.out.println(" ");
}

public static int[] highDef(int[] original) {
    int[] newarr = new int[original.length * 3 - 2];
    newarr[original.length * 3 - 3] = original[original.length-1];

    for(int i=0; i<original.length-1; i++){
        newarr[i*3] = original[i];
        int increment = (original[i+1] - original[i])/3;
        newarr[i*3+1] = original[i] + increment;
        newarr[i*3+2] = original[i] + increment*2;
    }

    return newarr;
}