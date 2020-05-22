private int findInsertPosition(StringBuilder pStringBuilder, String pFindPart){
    String HQL = pStringBuilder.toString().toUpperCase(Locale.US);
    int whereIndex = HQL.length();
    int findPartLength = pFindPart.length();
    while(whereIndex >= 0){
        whereIndex = HQL.lastIndexOf(pFindPart, whereIndex);
        if (whereIndex >=0){
            String rightPart = HQL.substring(whereIndex + findPartLength);
            int count = 0;
            for(char c : rightPart.toCharArray()){
                switch(c){
                    case ')': count--; break;
                    case '(': count++; break;
                }
            }
            if (count == 0) break;
            whereIndex--;
        }
    }
    return whereIndex;
}