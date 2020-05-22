for (String s : splitted) {
    if (DIGITS.contains(s))
        sb.append(DIGITS.get(s));
    else
        sb.append(s);
    sb.append(' ');
}