@Test
public void testSystemCurrentTimeMillis(@Mocked final System unused) {
    new NonStrictExpectations() {{
        System.currentTimeMillis(); result = 1438357206679L;
    }};
    long currentTime = System.currentTimeMillis();
    assertEquals(1438357206679L, currentTime);
}