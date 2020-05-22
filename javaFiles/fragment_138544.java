String string = "000";
StringBuilder output = new StringBuilder();

for (int i = 0; i < string.length(); i++) {

    // Get current character in the string
    char c = string.charAt(i);

    // Add the current character to the output
    output.append(c);

    // If more characters exist, add the pipe
    if (i != string.length() - 1) {
        output.append("|");
    }
}

System.out.println(output.toString());