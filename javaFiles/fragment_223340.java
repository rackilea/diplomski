ArrayList<String> wordList = new ArrayList<String>();
wordList.add("foo");
wordList.add("carrots");

String message = "The foo bar message about carrots";

// use this class to match each character with the regex dot
Pattern p = Pattern.compile(".", Pattern.DOTALL);
// use to create the new message from the words (some replaced with asterisk)
StringBuffer newMessage = new StringBuffer();
// loop through each word
for (String word : message.split(" ") ){
    // if it is in your list....
    if (wordList.contains(word)) {
        // add it to newMessage, but replaced by asterisk.
        newMessage.append(p.matcher(word).replaceAll("*"));
    } else {
        // add the unmodified word
        newMessage.append(word);
    }
    // add a space before we loop to the next word
    newMessage.append(" ");
}
// set the new message string with some words replaced
message = newMessage.toString().trim();
System.out.println(message);