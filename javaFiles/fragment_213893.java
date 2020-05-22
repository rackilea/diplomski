@RunWith(MockitoJUnitRunner.class)
public class ArticleManagerTest {

    @Mock private ArticleCalculator calculator;
    @Mock private ArticleDatabase database;
    @Spy private UserProvider userProvider = new ConsumerUserProvider();

    @Test public void shouldDoSomething() {
        // given
        ArticleManager manager = new ArticleManager(calculator, 
                                                    userProvider, 
                                                    database);

        // when 
        manager.initiateArticle();

        // then 
        verify(database).addListener(any(ArticleListener.class));
    }

    @Test public void shouldDoSomethingElse() {
        // given
        ArticleManager manager = new ArticleManager(calculator, 
                                                    userProvider, 
                                                    database);

        // when 
        manager.finishArticle();

        // then 
        verify(database).removeListener(any(ArticleListener.class));
    }
}