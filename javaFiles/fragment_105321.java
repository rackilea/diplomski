public static boolean contains(List<OutputElement> outputElements, String value) {
    for (OutputElement outputElement : outputElements) {
        if (outputElement.getValue().equals(value))
            return true;
    }
    return false;
}