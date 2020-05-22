@RunWith(MockitoJUnitRunner.class)
public class ArticleManagerTest {

    @Mock private ArticleCalculator calculator;
    @Mock(name = "database") private ArticleDatabase dbMock;
    @Spy private UserProvider userProvider = new ConsumerUserProvider();

    @InjectMocks private ArticleManager manager;

    @Test public void shouldDoSomething() {
        manager.initiateArticle();
        verify(database).addListener(any(ArticleListener.class));
    }

    @Test public void shouldDoSomethingElse() {
        manager.finishArticle();
        verify(database).removeListener(any(ArticleListener.class));
    }
}