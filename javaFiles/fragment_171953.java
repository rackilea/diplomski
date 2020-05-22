StringBuilder resultStr = new StringBuilder();
int currIndex = 0;
while (protectedM.find()) {
  protectedStrs.add(protectedM.group());
  appendInBetween(resultStr, str, current, protectedM.str());
  resultStr.append(protectedM.group());
  currIndex = protectedM.end();
}
resultStr.append(str, currIndex, str.length());