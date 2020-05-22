public static String reverse_recursion(String str) {
    String[] arry = str.split(" ", 2); //Split into a maximum of 2 Strings

    if (arry.length > 1) { //If there is more than 1 word in arry
        //Return the reverse of the rest of the str (arry[1])           
        //and concatenate together with the first word (arry[0])
        return reverse_recursion(arry[1]) + " " + arry[0];
    }

    return arry[0]; //If less than or equal to 1 word, just return that word
}