public static void main(String[] args)
{
    String word = "square";
    String output = word + "\n"; // Initialize with the word
    for (int i = 1; i < word.length() - 1; i++) { // From '1' to 'length - 1' because we don't want to iterate over the first and last characters
        output += word.charAt(i);
        for (int j = 0; j < word.length() - 2; j++) // To add spaces
            output += " ";
        output += word.charAt(word.length() - (i + 1)) + "\n";
    }
    for (int k = word.length() - 1; k >= 0; k--) // Add word in reverse
        output += word.charAt(k);

    System.out.println(output);
}