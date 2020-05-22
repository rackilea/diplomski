public static void StringCheck(String one, String []two){
    String[] numbersOne = one.split(", ");//1 2 3 4 5
    String result = "";
    for (int i = 0; i < two.length; i++) {
        int counter = 0;
        String [] numbersTwo = two[i].split(", ");//2 3 4 5 6
        for (int j = 0; j < numbersTwo.length; j++) {
            for (int k = 0; k < numbersOne.length; k++) {
                if(numbersTwo[j].equals(numbersOne[k])){
                    counter++;
                    break;
                }
            }
        }
        result+="Result "+(i+1)+":"+counter+" ";
    }
        textView3.setText(result); 
}