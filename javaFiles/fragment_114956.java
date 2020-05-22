for (int i = 0; i < length; ++i) {
    x = word.charAt(i);
    if (Character.isLetter(x)) {
        end.append(x);
    }
}