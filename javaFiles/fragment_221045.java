fr = new FileReader(path);
fr2 = new FileReader(path2);
while ((i = fr.read()) != -1 && (i2 = fr2.read()) != -1) {
    char c = (char) i;
    char c2 = (char) i2;
    if (Character.isDigit(c) && Character.isDigit(c2)) {
        int n = Character. getNumericValue(c);
        int n2 = Character.getNumericValue(c2);
        sum += (n + n2);
    } else {
        // TODO handle this somehow
    }
}