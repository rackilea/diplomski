//given
FileSystem fileSystemMock = mock(FileSystem.class);
InputStream streamMock = mock(InputStream.class);

given(fileSystemMock.open("file.txt")).willReturn(streamMock);

//when
//your code

//then
verify(streamMock).close();