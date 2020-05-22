public class MainClass {

    private static final String [] dataArray = {  "John , Comedy , 2000",
                        "John , Comedy , 2012",
                        "Alis , Comedy , 2005 ",
                        "Alis, Animation , 2003"};

    public static void main(String[] args) {
        int wordIndex = 0;
        Map<String, Integer> wordIndexMap = new HashMap<String, Integer>();    //Map to store Word and related index
        Map<Integer, String> reverseWordMap = new HashMap<Integer, String>();  //Map to store index to word
        String [] convertedArray = new String [dataArray.length];

        for(int index = 0; index < dataArray.length; index++) {
            String [] tokens = dataArray[index].trim().split("\\s*,\\s*");
            StringBuilder convertedString = new StringBuilder();
            boolean dataEncountered = false;
            for(int tokenIndex = 0; tokenIndex < tokens.length; tokenIndex++) {
                if(dataEncountered) {                      //Add ', ' only when something is added to the convertedString
                    convertedString.append(", ");
                }

                if(tokens[tokenIndex].matches("\\d+")) {      //To match the years like 2000, 2010 etc. This condition can be altered according to the requirement
                    convertedString.append(tokens[tokenIndex]);
                } else {
                    if(wordIndexMap.get(tokens[tokenIndex]) == null) {
                        wordIndexMap.put(tokens[tokenIndex], ++wordIndex);
                        reverseWordMap.put(wordIndex, tokens[tokenIndex]);
                    }
                    convertedString.append(wordIndexMap.get(tokens[tokenIndex]));
                }
                dataEncountered = true;
            }
            convertedArray[index] = convertedString.toString();
        }

        String [] reverseConvertedArray = new String[convertedArray.length];

        for(String data: convertedArray) {   //Print the converted array
            System.out.println(data);
        }

        for(int index = 0; index < convertedArray.length; index++) {
            String [] data = convertedArray[index].trim().split("\\s*,\\s*");
            StringBuilder convertedString = new StringBuilder();
            boolean dataEncountered = false;
            for(int arrayIndex = 0; arrayIndex < data.length; arrayIndex++) {
                if(dataEncountered) {
                    convertedString.append(", ");
                }

                if(arrayIndex + 1 == data.length) {         //To ignore the last item of the String
                    convertedString.append(data[arrayIndex]);
                } else {
                    convertedString.append(reverseWordMap.get(Integer.parseInt(data[arrayIndex])));
                }
                dataEncountered = true;
            }
            reverseConvertedArray[index] = convertedString.toString();
        }

        for(String data: reverseConvertedArray) {       //Print the reverse converted array
            System.out.println(data);
        }
    }

}