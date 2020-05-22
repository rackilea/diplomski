import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

public class LibraryServiceTest {

    @Test
    public void testMethod() throws ExecutionException {
        when(bookCache.get(eq(bookId), any(Callable.class))).thenReturn(book);
        
    }
}