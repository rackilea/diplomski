public void testNegate()
{
    Fraction g = new Fraction(1,3);
    g = g.negate(); //added "g ="
    assertEquals(-1, g.getNumerator());
    assertEquals(3, g.getDenominator());
}