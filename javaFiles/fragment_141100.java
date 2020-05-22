public static void main(String[] args) {
    String original[]={"string0,10","string1,45","string2,3", "string3,67"};
    int len = original.length;
    String result[] = new String[len];
    for(int i=0; i<len;i++) {       
        result[i] = original[i].split(",")[0];      
    }

    System.out.println(Arrays.toString(result));
}