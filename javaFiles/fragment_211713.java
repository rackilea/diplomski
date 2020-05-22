StringBuilder sb = new StringBuilder(str.length());
for (int i = 0; i < str.length(); ) {
    if (i + word.length() <= str.length() &&
            str.substring(i, i + word.length()).equals(word)) {
        sb.append(word);
        i += word.length();
    }
    else {
        sb.append('+');
        i += 1;
    }
}
return sb.toString();