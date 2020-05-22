@Mock Thingy testee;

interface Thingy {
    int f(String... arg);
}

@Test
public void test() {
    // given
    // works only if signature is `f(String[] arg)`
    // when(this.testee.f(Mockito.any(String[].class))).thenReturn(42);
    when(this.testee.f(Mockito.any())).thenReturn(42); // anyVararg() is deprecated

    // when
    final int result = this.testee.f(new String[] { "hello", "world" });

    // then
    assertThat(result, comparesEqualTo(42));
    // works only if signature is `f(String[] arg)`
    // verify(this.testee).f(Mockito.any(String[].class));
    verify(this.testee).f(Mockito.any());
}