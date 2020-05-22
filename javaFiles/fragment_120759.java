public static void sort(ArrayList<Number> list) {

Number temp = 0;

for (int i = 0; i < list.size() - 1; i++) {
    for (int j = i+1; j < list.size(); j++) {
        if (list.get(j).doubleValue() < list.get(i).doubleValue()) {
            temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
    }
}
}