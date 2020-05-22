StringBuffer nextGroup = new StringBuffer();
char nextChar = br.read();
while (nextChar != '.' && nextChar != -1) {
    nextGroup.append(nextChar);
    nextChar = br.read();
}
array[i][c] = nextGroup.toString();