StringBuffer outString = new StringBuffer();
StringTokenizer st = new StringTokenizer(input.toString());
while(st.hasMoreTokens()){
  String currentToken = (String)st.nextToken();
  if(currentToken.length() < 2){
    continue;
  }
  for(int i = 0; i < charSet.length; i++){
    if(charSet[i] == currentToken.charAt(0)){
      outString.append(currentToken);
      break;
    }
  }
}