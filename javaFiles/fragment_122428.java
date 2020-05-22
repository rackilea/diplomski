boolean contains = false;
for (char charToCheck = 'a'; charToCheck <= 'k'; charToCheck++) {
    if (operation.indexOf(charToCheck) >= 0) {
        // found something
        contains = true;
        break;
    }
}