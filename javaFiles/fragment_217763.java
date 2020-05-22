@Override
    protected Map<String, String> getParams() {
        //Initializes the map of the returning data
        Map<String, String> params = new HashMap<String, String>();
        //Adds a parameter to the map
        params.put("email", email);
        params.put("password", password);
        //returns the map
        return params;
    }