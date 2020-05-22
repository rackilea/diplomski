// Truncate trailing zeros
char[] nanosChar = new char[nanosString.length()];
nanosString.getChars(0, nanosString.length(), nanosChar, 0);
int truncIndex = 8;
while (nanosChar[truncIndex] == '0') {
    truncIndex--;
}

nanosString = new String(nanosChar, 0, truncIndex + 1);