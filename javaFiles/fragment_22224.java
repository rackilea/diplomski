@Test
public void testCount() {
    assertEquals(0, SimmonsPS5.count(0)); // 1 obj in table with name => 0 permutations
    assertEquals(1, SimmonsPS5.count(1)); // 2 obj in table with name => 1 permutation
    assertEquals(3, SimmonsPS5.count(2)); // 2 obj in table with name => 3 permutations (3c2)
    assertEquals(5050, SimmonsPS5.count(100)); // 100 obj in table with name => 100c2 permutations (100(100+1)/2)
}