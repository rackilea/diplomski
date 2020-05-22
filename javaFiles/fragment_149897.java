class abcTest
{
  @Parameters
  public static Collection<Object[]> testParameters()
  {
        return Arrays.asList(new Object[][] {
            {1, CoreMatchers.is(true)},
            {2, CoreMatchers.is(false)} 
        });
  }

  ..
  @Test
  public void test()
  {
      ...
      assertThat(value, matcher);
  }
}