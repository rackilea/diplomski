StringBuilder sb = new StringBuilder();
int index = 0;
boolean maxLengthReached = false;
while (!maxLengthReached) {
    maxLengthReached = true;
    for (String str : input) {
        if (index < str.length) {
            sb.append(str.charAt(index));
            maxLengthReached = false;
        }
    }
    index++;
}

return sb.toString();