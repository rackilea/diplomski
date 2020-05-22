boolean allWithinRenge = true;

for (String s : indexesString) { //iterate through indexesString
    if (!(Integer.parseInt(s) > 0 && Integer.parseInt(s) <= 12)) { //check the range of each element
        allWithinRenge = false;
        break; //break this loop, because an element is not within the range
    }
}

if (allWithinRenge) {
    // all numbers are within 1 and 12
} else {
    break yourLoop;
}