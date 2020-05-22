when(function.apply(anyString())).thenReturn("A","B","C");

    doReturn("Jim")
        .when(function)
        .apply("Jim");
    doReturn("Bob")
        .when(function)
        .apply("Bob");

    assertThat(function.apply("Jim")).isEqualTo("Jim");
    assertThat(function.apply("Bob")).isEqualTo("Bob");
    assertThat(function.apply("")).isEqualTo("A");
    assertThat(function.apply("")).isEqualTo("B");
    assertThat(function.apply("")).isEqualTo("C");
    assertThat(function.apply("")).isEqualTo("C");