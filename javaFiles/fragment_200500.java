public String slice_start(String s, int startIndex) {
    if (startIndex < 0) startIndex = s.length() + startIndex;
    return s.substring(startIndex);
}

public String slice_end(String s, int endIndex) {
    if (endIndex < 0) endIndex = s.length() + endIndex;
    return s.substring(0, endIndex);
}

public String slice_range(String s, int startIndex, int endIndex) {
    if (startIndex < 0) startIndex = s.length() + startIndex;
    if (endIndex < 0) endIndex = s.length() + endIndex;
    return s.substring(startIndex, endIndex);
}