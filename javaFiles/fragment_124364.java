import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

// ...

@ExtendWith(EasyMockExtension.class)
public class BookTest extends EasyMockSupport {

    @Mock
    public BookWindow bookWindow;

    public BookList bookList;

    @TestSubject
    public BookEditor bookEditor;

    @BeforeEach
    public void setUp() {
        bookList = new BookList();
        bookEditor = new BookEditor(bookList, bookWindow);
    }

    // ...