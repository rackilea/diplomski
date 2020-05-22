public static void main(String[] args) throws FileNotFoundException {

        Map<Integer, String> wordMap = new HashMap<Integer, String>();

        Pattern seaPattern = Pattern.compile("(.*?)\\[(.*?)\\],");
        String compressedSea = "see[2, 4, 5],sea[0, 1, 3],";
        Matcher seaMatcher = seaPattern.matcher(compressedSea);
        while (seaMatcher.find()) {
            String word = seaMatcher.group(1);
            String[] seaIndexes= seaMatcher.group(2).split(", ");
            for(String s : seaIndexes){
                wordMap.put(Integer.valueOf(s), word);
            }
        }
//HashMap will printout ordered by the key value.
//This is because the key is an Integer
//The hashed key value is therefore the key value itself.
        System.out.println(wordMap);
    }