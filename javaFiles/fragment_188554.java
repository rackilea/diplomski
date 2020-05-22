@Test
@SystemProperty(name = "os.name", value = "Windows")
public void aTest() {
    assertThat(systemIsWindows(), is(true));
}


@Test
@SystemProperty(name = "os.name", value = "MacOs")
public void aTest() {
    assertThat(systemIsWindows(), is(false));
}