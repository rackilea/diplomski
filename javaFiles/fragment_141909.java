String[] components = in.split("@" + u.username, -1);
text.append(components[0]);
for (int i = 1; i < components.length; i++) {
    text.append(str); // using the spannable from above
    text.append(components[i]);
}