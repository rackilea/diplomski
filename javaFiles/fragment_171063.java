if (rotation) {
    for (count++; count <= fullString.length - 1; count++) {
        text = fullString[count];
        if (text.trim().length() > 0) {
            return text;
        }
    }
}

if (!rotation) {
    for (count--; count >= 0; count--) {
        text = fullString[count];
        if (text.trim().length() > 0) {
            return text;
        }
    }
}