@Test
  public void example() {
    assertThat("isPresent() checks whether the function is defined for the input", //
        isEven(10).isPresent(), equalTo(true));
    assertThat("get() returns the supplier that actually computes the value", //
        isEven(10).get().get(), equalTo("10 is even"));
    assertThat("isPresent() checks whether the function is defined for the input", //
        isEven(11).isPresent(), is(false));
  }