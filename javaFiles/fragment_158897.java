for (String line: lines) {
    for (char chr: line) {
        if (chr == ' ') {
            continue;
        } else {
            characters.add(chr);
        }
    }
}