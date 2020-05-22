class Alphabet {
public static void main(String args[]) {

    // Create an array that will hold the grid
    char alphGrid[][] = genArray();

    // Two for loops to print the grid on the screen
    for(int i=0; i<26; i++) {

        for(int j=0; j<26; j++) {
            System.out.print(alphGrid[i][j]);
        }
        System.out.println();
    }

} // end of main

// Create a function to generate the grid
public static char[][] genArray(){
    char[][] arr = new char[26][26];

    // Two for loops to generate the grid
    for(int i = 0; i < 26; i++) {
        for(int j = 0; j < 26; j++) {

            // Creates an int that will later be cast to a char
            int let = i + j;

            // Keeps the int from getting too big
            if(let >= 26)
                let = let - 26;

            // Add 65 to the int so that the char will return letters and not ASCII symbols
            let = let + 65;

            // Cast the int to a char
            char letter = (char)let;

            // Put the char into its respective place in the array
            arr[i][j] = letter;

        }
    }

    // Returns the grid
    return arr;
}
}