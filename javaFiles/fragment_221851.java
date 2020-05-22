@Rule
public PrepareFile prepareFile = new PrepareFile();

@Test
@PrepareFile.FileName("foo1.m")
public void test1() {
    // Exercise
}

@Test
@PrepareFile.FileName("foo2.m")
public void test2() {
    // Exercise
}