import static org.hamcrest.Matchers.hasEntry;
import static org.mockito.Matchers.argThat;
@Before
public void setUp() {
  when(mockedObject.get((Map<String, String>) argThat(hasEntry("key", "value"))))
      .thenReturn(1);
}