StringBuilder buf = new StringBuilder(originalString.length());
for (int i = 0; i < originalString.length(); i++) {
    char c = originalString.charAt(i);

    if (Character.isUpperCase(c)) {
        buf.append(Character.toLowerCase(c));

    }
    else if (Character.isLowerCase(c)) {
        buf.append(Character.toUpperCase(c));

    }
    // Account for case: neither upper nor lower
    else {
        buf.append(c);
    }

}
return buf.toString();