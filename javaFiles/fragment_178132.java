String s = "{Student}{Subject}{Marks}100{/Marks}{/Subject}{/Student}";
ArrayList<String> tags = new ArrayList<>();
for(int i = 0; i < s.length(); i++) {
    StringBuilder sb = new StringBuilder(); // Use StringBuilder and its append() method to append Strings (it's more efficient than "+=")      String appended = ""; // This String will be appended when correct tag is found
    if(s.charAt(i) == '{') { // If start of tag is found...
        while(!(Character.isLetter(s.charAt(i)))) { // Skip characters that are not letters
        i++;
        }
        while(Character.isLetter(s.charAt(i))) { // Append String with letters that are found
            sb.append(s.charAt(i));
            i++;
        }
        if(!(tags.contains(sb.toString()))) { // Add final String to ArrayList only if it not contained here yet
            tags.add(sb.toString());
        }
    }
}
for(String tag : tags) { // Printing Strings contained in ArrayList and their length
    System.out.println(tag + ", length: " + tag.length());
}