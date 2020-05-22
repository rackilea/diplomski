// assuming that operationList and outputNum always 
//   have the same number of elements
for (int i = 1; i < operationList.size(); i++) {
  ...
  answer = outputNum.get(i - 1) * outputNum.get(i);
  ...
}