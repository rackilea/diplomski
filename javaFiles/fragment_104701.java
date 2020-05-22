@Test
    public void testCountFactors ()
    {
        assertEquals(1, Loops.countFactors(1));
        assertEquals(4, Loops.countFactors(6));
        assertEquals(2, Loops.countFactors(11));
        assertEquals(8, Loops.countFactors(30));
    }

    @Test
    public void testCountWhitespace ()
    {
        assertEquals(0, Loops.countWhitespace(""));
        assertEquals(0, Loops.countWhitespace("xyz"));
        assertEquals(10,
                Loops.countWhitespace("one two  three   four    "));
        assertEquals(8,
                Loops.countWhitespace("one\ttwo\n\nthree   four\n\t"));
    }