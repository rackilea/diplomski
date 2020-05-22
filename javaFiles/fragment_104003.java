[TestClass]
public abstract class SearchTests
{
    private ISearcher _searcherUnderTest;

    [TestSetup]
    public void Setup()
    {
        _searcherUnderTest = CreateSearcher();
    }

    protected abstract ISearcher CreateSearcher();

    [TestMethod]
    public void Test1(){/*do stuff to _searcherUnderTest*/ }

    // more tests...

    [TestClass]
    public class CoolSearcherTests : SearcherTests
    {
         protected override ISearcher CreateSearcher()
         {
             return new CoolSearcher();
         }
    }

    [TestClass]
    public class LameSearcherTests : SearcherTests
    {
         protected override ISearcher CreateSearcher()
         {
             return new LameSearcher();
         }
    }
}