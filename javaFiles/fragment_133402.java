List<Integer> found = new ArrayList<Integer>();
for (int i = 0; i < size; ++i) {
    if (list.get(i).getLastName().equals(lastName)) {
        found.add(i);
    }
}
if (found.isEmpty()) {
    System.out.println("Cant find " + lastName);
} else {
    System.out.print(lastName+ " is located at " + found.toString());
}