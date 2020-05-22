import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

...

List<String> mockedList = mock(List.class);
mockedList.add("test");

// this won't fail the test because the parameters match
verify(mockedList).add("test");

// this will fail the test because Mockito verifies the parameters and they don't match
verify(mockedList).add("other string");

// on the other hand, if you don't care about the parameters, you can use Matchers
verify(mockedList).add(anyString());
// or more generically
verify(mockedList).add(any(String.class));