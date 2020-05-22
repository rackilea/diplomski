loop:
for (int currentNum = 0; currentNum < arrayLength; currentNum++) {
    for (int i = currentNum + 1; i < arrayLength; i++) {
        if (x[currentNum].equals(x[i])) {
            continue loop;
        }
    }
    strings++;
}