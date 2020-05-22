for (int k = sectionStartIndex; k < sectionEndIndex; k++) {
    int j = sectionEndIndex - k;
    if (min > pts[j]) {
        System.out.println("minIndex, min, pts[" + j + "]: "
            + minIndex + ", " + min + ", " + pts[j]);
        min = pts[j];
        minIndex = x2Count;
    }
    if (max < pts[k]) {
        max = pts[k];
        maxIndex = x2Count;
    }
}