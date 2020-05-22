public List<String> getResult(){
    textEdit();

    ArrayList<String> result = new ArrayList<>();
    for(Map.Entry<String, Integer> entry : list.entrySet()){
        result.add(entry.getKey() + " " + entry.getValue());
    }
    return result;
}