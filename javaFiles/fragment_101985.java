ArrayList<String> result = new ArrayList();
for(int i = 0; i < firstList.size(); i++) {
    String item = firstList.get(i);
    if(secondList.contains(item)) {
        result.add(item);
    }
}