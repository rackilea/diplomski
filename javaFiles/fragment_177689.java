StringFinder finder = new StringFinder(phrase);
if        (finder.containsAll("turn", "on").andOneOf("computer", "pc").andNot("off").matches()) {
    turnOnComputer();
    return;
} else if (finder.containsAll("turn", "off").andOneOf("computer", "pc").andNot("on").matches()) {
    turnOffComputer();
    return;
} else if (finder.containsAll("turn", "on").andOneOf("light", "lamp").andNot("off").matches()) {
    ...
} else if (finder.containsAll("turn")) { // If we reached this point
    badPhrase();
} else if (...