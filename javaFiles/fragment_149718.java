public void replace(final int column, final String replacement, final File file, final String... appends) throws IOException {
    assert column >= 0 : "column < 0";
    final List<String> lines = new LinkedList<>();
    final Scanner reader = new Scanner(file, "UTF-8");
    while(reader.hasNextLine()){
        final String line = reader.nextLine().trim();
        if(line.isEmpty())
            continue;
        final String[] tokens = line.split(",");
        assert column < tokens.length-1 : "column > tokens.length-1";
        tokens[column] = replacement;
        final List<String> temp = new LinkedList<>();
        temp.addAll(Arrays.asList(tokens));
        temp.addAll(Arrays.asList(appends));
        lines.add(temp.stream().collect(Collectors.joining(",")));
    }
    reader.close();
    final BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
    lines.forEach(
            l -> {
                try{
                    writer.write(l);
                    writer.newLine();
                }catch(IOException ex){
                    ex.printStackTrace();
                }
            }
    );
    writer.flush();
    writer.close();
}