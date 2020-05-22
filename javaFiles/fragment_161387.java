public String getResponse()
{
    HashMap<String, String> responseMap = new HashMap<String, String>();
    HashMap<String, String> synonymMap = new HashMap<String, String>();

    responseMap.put("crash", "Hello there");
    // Load the response value.
    synonymMap.put("crash", "crash");
    synonymMap.put("crashed", "crash");
    synonymMap.put("crashes", "crash");
    // Load the synonyms.

    String input = "crashed";
    // Select input value.

        if(responseMap.containsKey(input))
        {
            // Response is already mapped to the word.
            return responseMap.get(input);
        }
        else
        {
            // Look for a synonym of the word. 
            String synonym = synonymMap.get(input);
            if(!synonym.equals(input) && responseMap.containsKey(synonym))
            {
                // If a new value has been found that is a key..
                return responseMap.get(synonym);
            }
        }
        // If no response, set default response.
    input = "This is a default response";
    return input;
}