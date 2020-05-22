List<String> matchFromFirstArray= new ArrayList<String>();
List<String> notMatchFromFisrtArray= new ArrayList<String>();
List<String> notMatchFromSecondArray= new ArrayList<String>();

matchFromFirstArray.addAll(assocIds);
matchFromFirstArray.retainAll(actionids); // retains all matching elements


notMatchFromFisrtArray.addAll(assocIds);
notMatchFromFisrtArray.removeAll(matchFromFirstArray); // retains all not matching elements from first array



notMatchFromSecondArray.addAll(actionids);
notMatchFromSecondArray.removeAll(matchFromFirstArray); // retains all not matching elements from second array