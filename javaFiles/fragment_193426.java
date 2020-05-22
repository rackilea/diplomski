@Test
public void verifyReadFiles(){
    //Your logic here to read process files
    //Yours assertions here   
    Assert.assertThat(isLoaded(file1), is(true));
}