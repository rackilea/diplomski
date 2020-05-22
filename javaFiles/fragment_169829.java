isa = new IntSortedArray();
int expected = 0;
for(int i: isa.getElements()) {
  expected += 1;
}
assertEquals(expected, IntSortedArray.MAX );