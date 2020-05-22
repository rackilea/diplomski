@Test
public void testHalfEach() {
    final int[] inp = new int[100_000];
    final int exp = -1;
    Arrays.fill(inp, 0, 50_000, 0);
    Arrays.fill(inp, 50_000, 100_000, 1);
    validate(inp, exp);
}

private void validate(int[] inp, int exp)
{
    PassingCars prog = new PassingCars();
    int ans = prog.solution(inp);
    assertEquals(exp, ans);
}