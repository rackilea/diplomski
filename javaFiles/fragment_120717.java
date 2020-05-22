ArrayList<ArrayList<Character>> answer = new ArrayList<>();
for (int i = 0; i < dictArray.size(); i++) { 
    ArrayList<Character> tempArray = new ArrayList<Character>();
    for (int j = 0; j < dictArray.get(i).length(); j++) {
        if(!tempArray.contains(dictArray.get(i).charAt(j))){
            tempArray.add(dictArray.get(i).charAt(j));
        }
    }
    answer.add(tempArray);
}