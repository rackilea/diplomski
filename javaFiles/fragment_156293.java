/*
        jsonString format could be
        { "A" : [ Array of A ] } OR
        { "B" : [ Array of B ] } OR
        { "C" : [ Array of C ] }

     */
    public static <T> List<T> getList(Class<T> clazz, String jsonString, String arrayName) {

        ObjectMapper mapper = new ObjectMapper();
        List<T> retVal = new ArrayList<T>();

        try {
            Map<String, List<T>> userData = mapper.readValue(jsonString, Map.class);

            List<T> l = userData.get(arrayName);

            for (T a: l) {
                retVal.add(mapper.readValue(mapper.writeValueAsString(a), clazz));
            } // for


        } catch (IOException e) {
            e.printStackTrace();
        }

        return retVal;

    }