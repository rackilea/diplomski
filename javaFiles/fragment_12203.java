int spaces = 0;
while (spaces < line.length() && line.charAt(spaces) == ' ')
    spaces++;

if (spaces < line.length()) {
    out.write(spaces + line.substring(spaces) + System.lineSeparator());
}