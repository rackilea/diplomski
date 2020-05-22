String inputString = "aaaabbbcbbcbb";
char charToDouble = 'c';

String result = "";
for(char c : inputString.toCharArray()){
  result += c;
  if(c == charToDouble){
    result += c;
  }
}