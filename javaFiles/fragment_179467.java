public static double roundedSum(String s) {
    String[] ls = s.split(" ");
    double sum = 0;

    for(int i = 0; i < ls.length; i++){ 
        sum += Double.parseDouble(ls[i]);
    }

    return Math.round(sum);
}