public static void main(String[] args) {
        String stringPara = "this example will remove the vowals aeiou";
        stringPara = removeCharFromString(stringPara, "a");
        stringPara = removeCharFromString(stringPara, "e");
        stringPara = removeCharFromString(stringPara, "i");
        stringPara = removeCharFromString(stringPara, "o");
        stringPara = removeCharFromString(stringPara, "u");
        System.out.println(stringPara);
    }

    public static String removeCharFromString(String str, String characterToRemove){
        while(str.contains(characterToRemove)){
            str = str.substring(0, str.indexOf(characterToRemove)) + str.substring(str.indexOf(characterToRemove)+1, str.length()) ;
        }
        return str;
    }