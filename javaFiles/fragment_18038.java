public String toString() {
    ...
    if (secondValue > 0 || nanoValue > 0) {
        buf.append(secondValue < 10 ? ":0" : ":").append(secondValue);
        ...
        }
    }
    return buf.toString();
}