@RunWith(PowerMockRunner.class)
 @PrepareForTest({Environment.class})
 public class LogUtilsTest {

private File file;

@Before
public void initialSetup() {
    PowerMockito.mockStatic(Environment.class);
    file = mock(File.class);
    when(Environment.getExternalStorageDirectory()).thenReturn(file);
    when(file.getAbsolutePath()).thenReturn("abc"); 
                    ( OR )
    //when(file.getAbsolutePath()).thenReturn(Mockito.anyString()); 
}

@Test
public void log_d() {
    LogUtils.log_d("tag", "message");
 }
}