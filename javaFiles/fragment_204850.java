try (BufferedReader br = new BufferedReader(new FileReader(myFile))) {
    String line = br.readLine();
    if (line == null) {
        return null;
    }
    StringBuilder retVal = new StringBuilder(line);
    line = br.readLine();
    while (line != null) {
        retVal.append(System.lineSeparator()).append(line);
        line = br.readLine();
    }
    return retVal.toString();
}