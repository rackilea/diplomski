public void replace(final int column, final String replacement, final File file, final String... appends) throws IOException {
    assert column >= 0 : "column < 0";
    final List<String> lines = new LinkedList<String>();
    final Scanner reader = new Scanner(file, "UTF-8");
    while(reader.hasNextLine()){
        final String line = reader.nextLine().trim();
        if(line.isEmpty())
            continue;
        final String[] tokens = line.split(",");
        assert column < tokens.length-1 : "column > tokens.length-1";
        tokens[column] = replacement;
        final StringBuilder builder = new StringBuilder();
        for(final String token : tokens)
            builder.append(token + ",");
        for(final String append : appends)
            builder.append(append + ",");
        builder.deleteCharAt(builder.length()-1);
        lines.add(builder.toString());
    }
    reader.close();
    final BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
    for(final String line : lines){
        writer.write(line);
        writer.newLine();
    }
    writer.flush();
    writer.close();
}