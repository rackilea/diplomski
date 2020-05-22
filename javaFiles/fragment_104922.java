String arrayStr = "";
for (int i = 0; i < array.length; i++) {
    arrayStr += course[i];
    if (i + 1 != array.length)
        arrayStr += ", ";
}