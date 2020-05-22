String string="I love #computers so #much omg #lol .";
    String[] stringParts = string.split("#");

    //'delete' first element.
    String[] parts = Arrays.copyOfRange(stringParts, 1, stringParts.length);

    int i = 0;
    String[] output = new String[10];

    for(String part : parts)
    {
        if(part.contains(" "))
        {
            String[] parts2 = part.split(" ");
            output[i] = parts2[0];
            i++;
        }
    }