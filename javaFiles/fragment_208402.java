import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

class MyBuggyClass
{
    @SuppressFBWarnings("URF_UNREAD_FIELD")
    private int unreadField;

    @SuppressFBWarnings("WMI_WRONG_MAP_ITERATOR")
    public void useKeySet() { ... }
}