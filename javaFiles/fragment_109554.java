List<CustomObject> list = new ArrayList<CustomObject>();
Comparator<CustomObject> comparator = new Comparator<CustomObject>() {
    @Override
    public int compare(CustomObject left, CustomObject right) {
        return left.getId() - right.getId(); // use your logic
    }
};

Collections.sort(list, comparator); // use the comparator as much as u want
System.out.println(list);