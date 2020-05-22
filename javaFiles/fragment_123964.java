public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        System.out.println("Programmed By Jason Silva");
        System.out.println();
        System.out.println("Enter a phone number or quit to exit");
        String number = stdin.nextLine();
        System.out.println(getNumber(number));
        stdin.close();
    }

    public static String getNumber(String numString) {
        StringBuilder numStrBuilder = new StringBuilder(); // I used StringBuilder because String is Immutable.
        for (int i = 0; i < numString.length(); i++) {
            char tempChar = numString.toUpperCase().charAt(i); // declared it to block variable for ease of use.
            if (Character.isLetter(tempChar)) {
                switch (tempChar) {
                case 'A':
                case 'B':
                case 'C':
                numStrBuilder.append("2"); // Append this value to StringBuilder if the character is a Letter.
                    break;
                case 'D':
                case 'E':
                case 'F':
                numStrBuilder.append("3");
                    break;
                case 'G':
                case 'H':
                case 'I':
                numStrBuilder.append("4");
                    break;
                case 'J':
                case 'K':
                case 'L':
                numStrBuilder.append("5");
                    break;
                case 'M':
                case 'N':
                case 'O':
                numStrBuilder.append("6");
                    break;
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                numStrBuilder.append("7");
                    break;
                case 'T':
                case 'U':
                case 'V':
                numStrBuilder.append("8");
                    break;
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                numStrBuilder.append("9");
                    break;
                }
            } else {
                numStrBuilder.append(tempChar); // Append the current character if it's not a letter.
            }

            if(i==8) {
                numStrBuilder.append("-"); // Append 'dash' whenever it reaches the 8th element of the String for formatting.
            }
        }
        return numStrBuilder.toString(); // Return it to String because you can't have character like 'dash' in a int.
}