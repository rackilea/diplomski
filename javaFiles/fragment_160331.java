public static void main(String[] args) throws Exception {
    List<String> strings = new ArrayList(){
        {
            add("abc|hjdj|kleygag|0|0|0|0|");
            add("ghys|jkugb|0|0|0");
            add("yuubf|kluygb|tyrffv|nutgv|0|0|0|0|0|");
            add("0|0|0|0|abdc|ghyft|rtyu");
            add("0|0|0|0|abdc|ghyft|rtyu|0|0|0|0|0|");
        }
    };

    // Non Regex
    System.out.println("Non Regex");
    for (String string : strings) {
        int startIndex = -1;
        int endIndex = -1;
        // Find first non zero character
        for (int i = 0; i < string.length(); i++) {
            if ('a' <= string.charAt(i) && string.charAt(i) <= 'z') {
                startIndex = i;
                break;
            }
        }
        // Find first pipe zero |0 after startIndex
        endIndex = string.indexOf("|0", startIndex);

        // Determine which substring() to use based on the endIndex results
        System.out.println(endIndex > -1 ? string.substring(startIndex, endIndex) : string.substring(startIndex));
    }
    System.out.println("");

    // Regex
    System.out.println("Regex");
    for (String string : strings) {
        System.out.println(string.replaceAll("\\|0|0\\||\\|$", ""));
    }
}