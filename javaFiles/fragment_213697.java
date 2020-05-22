for (int i = 0; i < p.length(); i++) {
    if (p.charAt(i) == '(') {
        push('x'); //doesn't matter what character you push on to the stack
    } else if (p.charAt(i) == ')') {
        pop();
    }

    //check if there are more closed than open
    if (stackIsEmpty()) {
        return false;
    }
}

if (isStackEmpty()) {
    return true;
} else {
    return false;
}