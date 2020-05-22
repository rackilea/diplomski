public static String solution(String s) {

    Map<Character, Integer> counts = new HashMap<Character, Integer>();

    // Go through each char and make a map of char to their counts. 
    for (char c : s.toCharArray()) {

        // See if the char is already in the map
        Integer count = counts.get(c);
        // if it wasn't then start counting from 1
        if (count == null) {
            count = 0;
        }
        count++;
        // update the count
        counts.put(c, count);
    }

    // now go through the map and print out any chars if their counts are higher than 1 (meaning there's a duplicate)
    for (Entry<Character, Integer> entry : counts.entrySet()) {
        if (entry.getValue() > 1) {
            System.out.println(MessageFormat.format("there are {0} {1}s",
                    entry.getValue(), entry.getKey()));
        }
    }
    return s;
}

public static void main(String args[]) {
    String s = "eeejiofewnj";
    solution(s);
}