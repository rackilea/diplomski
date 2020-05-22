//setup mock FileProvider
FileProvider fp = Mockito.mock(FileProvider.class);

//Setup mock File for FileProvider to return
File mockFile = Mockito.mock(File.class);
Mockito.when(mockFile.getName()).thenReturn("mockfilename");
//other methods...

//Make mock FileProvider return mock File
Mockito.when(fp.getFile("filename")).thenReturn(mockFile);

ClassUnderTest test = new ClassUnderTest();
test.setFileProvider(fp); //inject mock file provider

//Also set up mocks for Buzz,, Widget, and anything else

//run test
test.doFizzOnBuzz(...)

//verify that FileProvider.getFile() was actually called:
Mockito.verify(fp).getFile("filenane");