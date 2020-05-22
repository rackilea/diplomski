public static void main(String[] args){
    int[] s = new int[]{1, 2, 3, 4, 5, 107, 1060};
    System.out.println(m(s, 6));
}

public static double m(int[] s, int i){
    double result;
    if(i > 0){
        result = 1.0 * s[i]/(s[i] + 1) + m(s, i - 1);
    } else{
        result = 1.0 * s[i]/(s[i] + 1);
    }
    return result;
}