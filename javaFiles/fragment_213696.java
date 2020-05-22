int openParentheses = 0;

for (int i = 0; i < p.length(); i++) {
    if (p.charAt(i) == '(') {
        openParentheses++;
    } else if (p.charAt(i) == ')') {
        openParentheses--;
    }

    //check if there are more closed than open
    if (openParentheses < 0) {
        return false;
    }
}

if (openParentheses == 0) {
    return true;
} else {
    return false;
}