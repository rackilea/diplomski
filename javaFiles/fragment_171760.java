Iterator<Integer[]> it = A.Unassigned.iterator();
while (it.hasNext()) {
    Integer intArray = it.next();
    A.Shanghai.add(intArray);
    it.remove();
}