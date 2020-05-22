for (int i = 0; i < list.size(); i++) {
    Integer arrayInt = list.get(i);
    temp.add(arrayInt);

    if (temp.size() % 300 == 0) {
        listOfArrays.add(temp);
        temp = new ArrayList<>();
    }
}