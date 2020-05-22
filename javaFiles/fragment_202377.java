Function<String, String> function = mock(Function.class);
    when(function.apply(anyString())).thenReturn("A","B","C");
    when(function.apply("Jim")).thenReturn("Jim");
    when(function.apply("Bob")).thenReturn("Bob");

    assertThat(function.apply("Jim")).isEqualTo("Jim");
    assertThat(function.apply("Bob")).isEqualTo("Bob");
    assertThat(function.apply("")).isEqualTo("A");
    assertThat(function.apply("")).isEqualTo("B");
    assertThat(function.apply("")).isEqualTo("C");
    assertThat(function.apply("")).isEqualTo("C");