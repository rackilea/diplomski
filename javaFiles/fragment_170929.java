public class CollectionCountMatcher implements IArgumentMatcher
{
    private int expectedCount;

    public CollectionCountMatcher(int count) {
        super();
        this.expectedCount = count;
    }

    public boolean matches(Object actual) {
         return (actual instanceof Collection) 
         && ((Collection) actual).size() == expectedCount;
    }

    public static final Integer eqObject(Integer inValue) {
        EasyMock.reportMatcher(new CollectionCountMatcher (inValue));
        return inValue;
    }

    public void appendTo(StringBuffer buffer) {
        buffer.append("collectionContains(" + expectedCount + ")");
    }
}