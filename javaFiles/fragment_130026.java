private String removeDuplicates(String userKeyword){

        int charLength = userKeyword.length();
        String modifiedKeyword="";
        for(int i=0;i<charLength;i++)
            {
             if(!modifiedKeyword.contains(userKeyword.charAt(i)+""))
                 modifiedKeyword+=userKeyword.charAt(i);
            }
        return modifiedKeyword;
    }