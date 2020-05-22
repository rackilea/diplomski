String header="Requirements ID,Requirements Number,Requirements Desc,Requirements Text,Requirements Date";
StringTokenizer st = new StringTokenizer(header,",") ;
List<String> strList = new ArrayList<String>() ;
while (st.hasNextToken()) {
  strList.add(st.nextToken()) ;
}