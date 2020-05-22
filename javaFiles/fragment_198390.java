/**
     * Returns the given String with a fixed number of letters
     * 
     * @param string
     * @param letters
     * @return A String with the given length followed by ...
     */
    public static String getMinString(String string, int letters) {
        if (string.length() < letters)
            return string;
        else
            return string.substring(0, letters) + "...";
    }