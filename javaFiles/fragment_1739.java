public static boolean isUniqueChars2(String str) {
     // Create a new boolean array of 256 characters to account for basic ascii and extended ascii characters
     boolean[] char_set = new boolean[256];

     // Iterate through the string we are testing
     for (int i = 0; i < str.length(); i++) {

         // Get the numerical (ascii) value of the character in the `str` at position `i`.
         int val = str.charAt(i);

         // If char_set[val] has been set, that means that this character was already present in the string. (so in string 'hello' this would be true for the second 'l')
         if (char_set[val]) {
             return false;
         }
         // If the character hasn't been encountered yet (otherwise we would have returned false above), then mark this particular character as present in the string
         char_set[val] = true;
     }
     // If the function hasn't returned false after going through the entire string that means that each character is unique - thus returning true
     return true;
}