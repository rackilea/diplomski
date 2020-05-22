public double getAverage(){        
    String[] inputs = new String[]{Str1, Str2, Str3, Str4, Str5, Str6, Str7};
    int sum = 0;
    for (String input : inputs) {
        sum += Integer.parseInt(input);
    }      
    return sum / 160d;
}