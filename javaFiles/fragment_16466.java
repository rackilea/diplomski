private ArrayList<Person> searchList(ArrayList<Person> list) {
    ArrayList<Person> tempList = new ArrayList<>();
    for (int i = 0; i < list.size(); i++) {
        if (list.get(i).isChecked()) {
            tempList.add(list.get(i));
        }
    }
    return list;
}