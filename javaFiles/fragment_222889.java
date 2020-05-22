List<String> al = new ArrayList<>();
for (int i = 0; i < 23; i++) {
    for (int j = 0; j < 6; j++) {
        String seat = String.valueOf(i + 1) + Character.toString((char) ('A' + j));
        al.add(seat);
    }
}
System.out.println(al);