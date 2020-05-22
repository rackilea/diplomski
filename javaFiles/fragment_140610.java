public static boolean isPalindrome(String[] input) {
        for (int i=0; i<input.length; i++) { // Checks each element
            if (!input[i].equals( input[input.length-1-i])){
                return false; // If a single instance of non-symmetry
            }
        }
        return true; // If symmetrical, only one element, or zero elements
}