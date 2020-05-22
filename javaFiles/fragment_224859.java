public static void main(String[] args) {
    String[] strings = { "hello", "apple", "hat", "cat", "Banana", "AAA" };
    // Displaying the initial array..
    System.out.println(Arrays.toString(strings));
    orderByVowels(strings);
    System.out.println(Arrays.toString(strings));
}

public static void orderByVowels(String[] order) {

    for (int i = 0; i < order.length; i++) {
        for (int j = i + 1; j < order.length; j++) {
            int countI = getVowelCount(order[i]);
            int countJ = getVowelCount(order[j]);
            if(countI > countJ
                    || (countI == countJ && order[i].compareTo(order[j]) > 0)){
                String tppp = order[i];
                order[i] = order[j];
                order[j] = tppp;
            }
        }
    }
}

public static int getVowelCount(String input){
    int count = 0;
    for (int j = 0; j < input.length(); j++) {
        char c =input.toLowerCase().charAt(j);
        if(c=='a')
            count++;
        else if(c=='e')
            count++;
        else if(c=='i')
            count++;
        else if(c=='o')
            count++;
        else if(c=='u')
            count++;
    }
    return count;
}