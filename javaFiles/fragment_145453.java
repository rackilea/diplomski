public String extractMultiples(String plainString, String targeted) {
    StringBuffer sb = new StringBuffer();

    // split covers all occurrences in the beginning;empty element, and in
    // the middle
    String[] result = plainString.split(targeted);
    for (int i = 0; i < result.length; i++) {
        sb.append(result[i]);
        if (i < result.length - 1)// not the last one
            sb.append(targeted);
    }

    // in the end
    if (plainString.endsWith(targeted))
        sb.append(targeted);
    return sb.toString();
}