public String bracketize() {
    String chars = ...; // you can put whatever input (such as 'these are some chars *£&$')
        String keyword = ...; // you can put whatever keyword (such as *£&$^%)
        String longest = "";
        for(int i=0;i<keyword.length()-1;i++) {
            for(int j=keyword.length(); j>i; j--) {
                String tempString = keyword.substring(i,j);
                if(chars.indexOf(tempString) != -1 && tempString.length()>longest.length()) {
                    longest = tempString;
                }
            }
        }
       if(longest.length() == 0)
           return chars; // no possible substring of keyword exists in chars, so just return chars
       String bracketized = chars.substring(0,chars.indexOf(longest))+"("+longest+")"+chars.substring(chars.indexOf(longest)+longest.length());
       return bracketized;
}