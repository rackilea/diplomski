0int spaces = 0;
0while (spaces < line.length() && line.charAt(spaces) == ' ')
4spaces++;
0if (spaces < line.length()) {
4out.write(spaces + line.substring(spaces) + System.lineSeparator());
0}