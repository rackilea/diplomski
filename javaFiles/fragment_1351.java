when() requires an argument which has to be 'a method call on a mock'.
For example:
    when(mock.getArticles()).thenReturn(articles);

Also, this error might show up because:
1. you stub either of: final/private/equals()/hashCode() methods.
   Those methods *cannot* be stubbed/verified.
2. inside when() you don't call method on mock but on some other object.
3. the parent of the mocked class is not public.
   It is a limitation of the mock engine.