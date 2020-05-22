for (int i = (length - 1); i >= 0; i--) {
    x = word.charAt(i);
    if (Character.isLetter(x)) {
        end.append(x);
    }
}