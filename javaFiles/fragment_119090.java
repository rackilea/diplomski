// accepts a string and a char to find the number of occurrences of
public static int get_count(String s, char c) {    

    int count = 0;                        // count initially 0

    for (int i = 0; i < s.length(); i++)  // loop through the whole string
        if (s.charAt(i) == c)
            count ++;                     // increment every time an occurrence happens

    return count;                         // return the count in the end

}