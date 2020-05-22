occurrences = new int[256];
for (fileName: fileNameList) {
    occurrences[(int)fileName.charAt(0)] += 1;
}
for (int i = 'A', i <= 'Z'; i++) {
    if (occurrences[i] > 0) {
        AlphabetList.add((char)i)
    }
}
for (int i = '0', i <= '9'; i++) {
    if (occurrences[i] > 0) {
        NumberList.add(i - '0')
    }
}