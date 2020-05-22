public static int getIndex(int a){
    for (int i = 31; i >= 0; i--) {
        if (((a >> i) & 1) == 1)
            return i;
    }

    return 0;
}

public static void main(String []args){
    int a = 10;

    double index = Math.pow(2, getIndex(a));
    System.out.println(index);  
}