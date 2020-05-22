public static void returnVariants(String input){
        List<String> output = new ArrayList<String>();
        StringBuffer word = new StringBuffer(input);
        output.add(input);

        String letters = "ac";
        int lettersLength = letters.length();
        int wordLength = word.length();
        String replacement = "";

        for (int i = 0; i < lettersLength; i++) {
            for (int j = 0; j < wordLength; j++) {
                if(word.charAt(j)==letters.charAt(i)){
                    if (word.charAt(j)=='a'){
                        replacement = "ab";
                    }else if (word.charAt(j)=='c'){
                        replacement = "cd";
                    }
                    List<String> tempList = new ArrayList<String>();
                    for (int k = 0; k < replacement.length(); k++) {
                        for (String variant : output){
                            StringBuffer tempBuffer = new StringBuffer(variant);
                            String combination = tempBuffer.replace(j, j+1, replacement.substring(k, k+1)).toString();
                            tempList.add(combination);
                        }
                    }
                    output.addAll(tempList);
                    if (j==0){
                        output.remove(0);
                    }
                }
            }
        }
        Set<String> uniqueCombinations = new HashSet(output);
        System.out.println(uniqueCombinations);
    }