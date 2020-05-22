public class ArticleManagerTest {

    @Test public void shouldDoSomething() {
        // given
        ArticleCalculator calculator = mock(ArticleCalculator.class);
        ArticleDatabase database = mock(ArticleDatabase.class);
        UserProvider userProvider = spy(new ConsumerUserProvider());
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
        ArticleCalculator calculator = mock(ArticleCalculator.class);
        ArticleDatabase database = mock(ArticleDatabase.class);
        UserProvider userProvider = spy(new ConsumerUserProvider());
        ArticleManager manager = new ArticleManager(calculator, 
                                                    userProvider, 
                                                    database);

        // when 
        manager.finishArticle();

        // then
        verify(database).removeListener(any(ArticleListener.class));
    }
}