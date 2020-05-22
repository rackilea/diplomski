public static int[] fillArray(String s, int size){
    String[] tok = str.split(",");
    int[] newArr = new int[size];

    for(int x=0; x<Math.min(size, tok.length); x++)
        newArr[x] = Integer.parseInt(tok[x]);

    for(int x=Math.min(size, tok.length); x<Math.max(size, tok.length); x++)
        newArr[x] = 0;

    return newArr;
}