for (int i = 1; i < list.size(); i++) {
    int pos = nthIndexOf(list.get(i), '.', 3);
    if (!list.get(i).substring(0, pos).equals(list.get(i - 1).substring(0, pos))) {
        System.out.println(list.get(i));
    }
}