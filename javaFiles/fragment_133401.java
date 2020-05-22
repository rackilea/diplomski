int found = -1;
for (int i = 0; i < size && found == -1; ++i) {
    if (list.get(i).getLastName().equals(lastName)) {
        found = i;
    }
}
if (found >= 0) {
    System.out.print(lastName+ " is located at " + found);
} else {
    System.out.println("Cant find " + lastName);
}