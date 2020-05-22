boolean found = false;
for (char ch : operation.toCharArray()) {
    for (ch charToCheck = 'a'; charToCheck <= 'k'; charToCheck++) {
        if (ch == charToCheck) {
            found = true;
            break;
        }
    }
    if (found) {
        break;
    }
}