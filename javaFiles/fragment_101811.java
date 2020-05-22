ArrayList<String> trace = new ArrayList<String>();
if(!element.startsWith("PRINT")) {
    List<String> tokens = new ArrayList<String>();
    while(st.hasMoreTokens()) {
        tokens.add(st.nextToken());
    }

    // Size of tokens has to be more then 3, otherwise you will get another error.
    if (tokens.size() >= 3) {
        for(String key: expression.keySet()) {
            if(tokens.get(0).equals(key)) {
                 // Do your other operations...
                 trace.add(key + "Changed from " + expression.get(key) + " to " + tokens.get(2));
            }
        }

        // Do some more operations ...
        int value = 0;
        if (StringUtils.isNumeric(tokens.get(2))) {
            value = Integer.parseInt(tokens.get(2));
        }
        // Default value will be 0.
        expression.put(tokens.get(0), value);
    }
    tokens.clear();
}