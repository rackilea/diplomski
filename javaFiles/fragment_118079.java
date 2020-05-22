this.extractedIdentifiers = identifiers.rdd().map(
    new MyFunction<Row, Map<String, String>>() {

    private static final long serialVersionUID = 1L;

    @Override
    public Map<String, String> apply(Row line)
    {
        Map<String, String> identifier= new HashMap<>();

        for (int i = 0; i < parameters.size(); i++) 
        {
            identifier.put(parameters.get(i), line.getString(i));
        }

        return identifier;
    }
}).collect(); //This returns the list of maps...