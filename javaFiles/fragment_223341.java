public static void main(String[] args) {
    // Your input string
    String message = "The foo bar message about carrots. Carrots suck so do parrots. Parrotsucker is partially masked. Carrots was already replaced.";
    System.out.println(message);

    // An array of words you want to mask
    ArrayList<String> wordList = new ArrayList<String>();
    wordList.add("foo");
    wordList.add("carrots");
    wordList.add("parrots");

    // Create a regex to match the banned words.... in this case it will be "foo|carrots|parrots", case insensitive
    String regex = Arrays.toString(wordList.toArray());
    regex = regex.substring(1, regex.length()-1).replaceAll(", ", "|");
    Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
    System.out.println("Regex: " + p);

    // Keep track of the asterisks strings by length so we don't generate more than once
    Map<Integer, String> maskMap = new HashMap<Integer, String>();
    // Since we use replaceAll we might get a match more than once, so we can track and skip once that have already been handled
    Vector<String> replaced = new Vector<String>();
    // Find a list of banned words in the input message
    Matcher m = p.matcher(message);
    // Loop over each of the matches
    while (m.find()){
        // Get the text of each match
        String match = m.group();
        // Have we already replaced it in the message?
        if ( !replaced.contains(match) ){
            // This is what we will replace it with
            String mask = null;
            // See if we have a string the same length as the current match
            if ( maskMap.containsKey(match.length())) {
                // If so, get it out of the map.
                mask = maskMap.get(match.length());
                System.out.println("Got mask from maskMap: " + mask);
            } else {
                // No mask, so generate one and save it in the Map
                StringBuffer maskBuffer = new StringBuffer("*");
                while ( maskBuffer.length() < match.length() ){
                    maskBuffer.append("*");
                }
                mask = maskBuffer.toString();
                maskMap.put(mask.length(), mask);
                System.out.println("Generated new entry for maskMap: " + mask);
            }
            // Replace the matched banned word with the correct mask
            message = message.replaceAll(match, mask);
            // Track that we already replaced this word
            replaced.add(match);
            System.out.println((new StringBuffer("   Replaced '").append(match).append("' with '").append(mask).append("'")).toString());
        } else {
            System.out.println("Aready replaced: " + match);
        }
    }

    // The message with banned words masked.
    System.out.println(message);

    System.exit(0);

}