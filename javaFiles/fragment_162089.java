while(st.hasMoreTokens()){ 
    String currentToken = st.nextToken();
    if(!cityList.contains(currentToken.trim())){ 
        cityList.add(currentToken.trim());
    }//if
}//while hasMoreTokens