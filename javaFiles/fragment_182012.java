public class StringTemplate {
    private String filePath;
    private String charsetName;
    private Collection<AbstractMap.SimpleEntry<String, String>> args;

    public StringTemplate(String filePath, String charsetName,
                          Collection<AbstractMap.SimpleEntry<String, String>> args) {
        this.filePath = filePath;
        this.charsetName=charsetName;
        this.args = args;
    }

    public String generate() throws FileNotFoundException, IOException {
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                getClass().getResourceAsStream(filePath),charsetName));
        try {
            String line = null;

            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append(System.getProperty("line.separator"));
            }
        } finally {
            reader.close();
        }
        for (AbstractMap.SimpleEntry<String, String> arg : this.args) {
            int index = builder.indexOf(arg.getKey());
            while (index != -1) {
                builder.replace(index, index + arg.getKey().length(), arg.getValue());
                index += arg.getValue().length();
                index = builder.indexOf(arg.getKey(), index);
            }
        }
        return builder.toString();
    }
}