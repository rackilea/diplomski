public static void main (String[] args)
    {
        /* Function Call */
        System.out.println(getSubstring("012.345.Sub_16462_52034247_20151130_.xlsx",'_'));
    }

    /**
      * Get Sub-String Function
      * Arguments: Original String, Search Char
      * Output: Filtered Sub-String
    **/

    public static String getSubstring(String originalString, char searchChar) {
        /* Char Occurrence */
        int occurrence = 4;
        /* Last Position */
        int position = originalString.lastIndexOf(searchChar);
        /* Search nth Last Occurrence */
        while (occurrence -- > 1 && originalString.lastIndexOf(searchChar, position-1) != -1)
            position = originalString.lastIndexOf(searchChar, position-1);
        /* Add Additional Filter & Return Sub-String */
        return originalString.substring(position+1,originalString.lastIndexOf('.') - 1);
    }