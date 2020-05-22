class UtilClassTest {


        @Test(expected = FileAlreadyExistsException.class)
        public void shouldThrowExceptionWhenRootPathExists() {
            FileSystem mockFileSystem = Mockito.mock(FileSystem.class);
            Mockito.when(mockFileSystem.exists(anyPath())).return(true);
            UtilClass util = new UtilClass(mockFileSystem);
            util.createDirectories(mock(Path.class), mock(Scaffolding.class))
        }
    }