// Assuming open brackets have corresponding close brackets
int brackets = 0;
int currIndex = 0;
List<String> output = new ArrayList<String>();
for (int i = 0; i < str.length(); i++) {
    if (isOpenBracket(str.charAt(i))) {
        brackets++;
    } else if (isCloseBracket(str.charAt(i))) {
        brackets--;
    } else if (str.charAt(i) == ',') {
        output.add(str.substring(currIndex, i));
        currIndex = i + 1;
    }
}
output.add(currIndex, str.length());
return output;