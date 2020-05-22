private void customSplit(String source) {
    String[] tokens = source.split(";");
    for (int i = 0; i < tokens; i++) {
        System.out.println("Token" + i + "is: " + token[i]);
    }
}