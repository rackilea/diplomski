public static void stringRvrs(String x, int length){
    String result = "";
    for(int i = length - 1; i >= 0; i--){
        result = result + x.charAt(i);
    }
    System.out.println(result);
}