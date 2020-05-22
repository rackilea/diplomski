List<Object[]> fromDB = (ArrayList<Object[]>) query.getResultList();
List<Fruits> fruits = new ArrayList();
for (Object[] o : fromDB) {
    Fruits f = new Fruits(fromDB[0], fromDB[1], 0);
    fruits.add(f);
}