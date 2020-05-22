private ArrayList<String> splitNames(ArrayList<String> listOfNames) {
    String temp = "";
    List<String> splitName;
    List<List<String>> listSplitName = new ArrayList<List<String>>();
    ArrayList<String> toReturn = new ArrayList<String>();

    if (listOfNames.size() == 1) {
        temp = listOfNames.get(0);
        splitName =  new ArrayList<String>(Arrays.asList(temp.split(" ")));
        listSplitName = generatePerm(splitName);
        for (int i = 0; i < listSplitName.size(); i++) {
            toReturn.add(listSplitName.get(i).toString());
        }
        return toReturn;
    }
    else {
        for (int i = 0; i < listOfNames.size(); i++) {
            temp = listOfNames.get(i);
            splitName = new ArrayList<String>(Arrays.asList(temp.split(" ")));
            listSplitName = generatePerm(splitName);
            for (int j = 0; j < listSplitName.size(); j++) {
                toReturn.add(listSplitName.get(j).toString());
            }
        }
        return toReturn;
    }
}

private List<List<String>> generatePerm(List<String> original) {
    if (original.size() == 0) {
        List<List<String>> result = new ArrayList<List<String>>();
        result.add(new ArrayList<String>());
        return result;
    }
    String firstElement = original.remove(0);
    List<List<String>> returnValue = new ArrayList<List<String>>();
    List<List<String>> permutations = generatePerm(original);
    for (List<String> smallerPermutated : permutations) {
        for (int index=0; index <= smallerPermutated.size(); index++) {
            List<String> temp = new ArrayList<String>(smallerPermutated);
            temp.add(index, firstElement);
            returnValue.add(temp);
        }
    }
    return returnValue;
}