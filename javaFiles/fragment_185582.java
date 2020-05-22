for (short j = 0; j < codeSection.length(); j++) {
    //Check the character
    if (codeSection.charAt(j) == '[') {
        balance++;
    } else if (codeSection.charAt(j) == ']') {
        balance--;
    }
    //Check if it's the right bracket
    if (balance == 1) {
        endPoint = j;
        break; // Stop when you find the ] position
    }
}