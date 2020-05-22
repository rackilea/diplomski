private static Pattern allParamsPattern = Pattern.compile("(\\(.*?\\))");
private static Pattern paramsPattern = Pattern.compile("(\\[?)(C|Z|S|I|J|F|D|(:?L[^;]+;))");


int getMethodParamCount(String methodRefType) {
    Matcher m = allParamsPattern.matcher(methodRefType);
    if (!m.find()) {
        throw new IllegalArgumentException("Method signature does not contain parameters");
    }
    String paramsDescriptor = m.group(1);
    Matcher mParam = paramsPattern.matcher(paramsDescriptor);

    int count = 0;
    while (mParam.find()) {
        count++;
    }
    return count;
}