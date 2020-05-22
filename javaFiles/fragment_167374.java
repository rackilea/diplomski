Map<String, String> inputMap = new HashMap<String, String>();

String[] tokens = str.split("||");

for(String token : tokens)
{
    // Cycle through each token.


    String key = token.split("::")[0];
    String value = token.split("::")[1];

    inputMap.put(key, value);
}