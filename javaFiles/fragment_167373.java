String[] tokens = str.split("||");

for(String token : tokens)
{
    // Cycle through each token.


    String key = token.split("::")[0];
    String value = token.split("::")[1];

    if(key.equals(input))
    {
        // input being the user's typed in value.
        return value;
    }
}