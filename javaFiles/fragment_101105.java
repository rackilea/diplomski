int count = 0;
while (true) {
    int n = input.read();
    if (n == (fromAsByteArray[count] & 255)) {
        ++count;
        if (count==fromAsByteArray.length) { // match found
            output.write(toAsByteArray);
            count = 0;
        }
    } else { // mismatch
        output.write(fromAsByteArray, 0, count); // flush matching chars so far
        count = 0;
        if (n == -1) break;
        output.write(n);
        }
    }
}