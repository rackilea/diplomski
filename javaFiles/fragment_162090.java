while(st.hasMoreTokens()){ 
    String firstToken = st.nextToken().trim();
    String secondToken = st.nextToken().trim();
    cityGraph[cityList.indexOf(firstToken)][cityList.indexOf(secondToken)] = 1; 
    cityGraph[cityList.indexOf(secondToken)][cityList.indexOf(firstToken)] = 1; 
}//while hasMoreTokens