public static void main(String[] args){
    List<Car> list = new ArrayList<>(Arrays.asList(new Car("Nissan", "Black", "KL1", "4"),
            new Car("Ford", "Red", "LL0", "4")));

    String id = "KL1";
    // Following code will find and remove the match from the list.
    // this for loop do exactly what it is doing "list.removeIf(i -> i.getID().equals(id));"
    for (int i = 0; i < list.size(); i++) {
        if (list.get(i).getID().equals(id)) {
            list.remove(i);
            break;
        }
    }
}