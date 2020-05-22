for (char c : firstString.toCharArray()) {
        if (! contains(secondString.toCharArray(), secondString.length(), c)) {
            out[index++] = c;
        }
    }
    for (char c : secondString.toCharArray()) {
        if (! contains(firstString.toCharArray(), firstString.length(), c)) {
            out[index++] = c;
        }
    }