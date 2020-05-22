final static String[][] code = {...}

public static void main(String[] args){
    printMorse("   Hello     World!");
}

static void printMorse(String input) {
    System.out.printf("%s %n", input);

    input = input.trim().replaceAll("[ ]+", " ").toUpperCase();

    for (char c : input.toCharArray()) {
        // Find the pair for the character
        for(String[] pair : code) {
            if(pair[0].equals(String.valueOf(c))) {
                System.out.printf("%s ", pair[1]);
            }
        }
    }

    System.out.println("\n");
}