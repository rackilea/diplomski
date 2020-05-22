public List<List<Integer>> readFile(String fileName)
        throws FileNotFoundException, IOException {
    BufferedReader br = Files.newBufferedReader(Paths.get(fileName));
    List<List<Integer>> values = new ArrayList<>();


    for(String line; (line = br.readLine()) != null;){
        String[] splitLine = line.trim().split("\\s+");

        if(splitLine.length < 2)
            values.add(parseSingleDigitValues(splitLine[0].toCharArray()));
        else
            values.add(parseDelimitedValues(splitLine));

    }

    return values;
}

private List<Integer> parseSingleDigitValues(char[] line) {
    List<Integer> values = new ArrayList<>();
    for(char c: line){
        values.add(Integer.parseInt(String.valueOf(c)));
    }
    return values;

}

private List<Integer> parseDelimitedValues(String[] line) {
    List<Integer> values = new ArrayList<>();
    for(String str :line)
        values.add(Integer.parseInt(str));
    return values;
}