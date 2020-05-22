StringBuilder str = new StringBuilder();
String[] splitStr = lines.split(" ");
for (int i = splitStr.length; i > 0; i--) {
    str.append(splitStr[i - 1]).append(" ");
}

buffer.add(str.toString());  //I wanted to put the words array in here instead of "lines" but didn't know how