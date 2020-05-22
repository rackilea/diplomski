@Bean
public MoveToHdfs fileMover() {
    MoveToHdfs fileMover = Mockito.mock(MoveToHdfs.class);
    when(fileMover.move(anyString(), anyString(), anyBoolean())).thenReturn(true);
    return fileMover;
}