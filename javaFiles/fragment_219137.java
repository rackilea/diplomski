@Test
public void test(){
    File mockedFile = Mockito.mock(File.class);
    Mockito.when(mockedFile.exists()).thenReturn(true);
    Mockito.when(mockedFile.isFile()).thenReturn(true);
    List<File> files = new ArrayList<>();
    files.add(mockedFile);
    MyTestClass myTestClass = new MyTestClass();
    myTestClass.deleteMyFile(files);
}