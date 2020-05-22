public class IDontWantOthersToKnowIObserve
{
    private class HiddenObserver implements Observer
    {
        public void handleSomeEvent(Object someObjectOfImportance)
        {
           ...
        }
    }

    ... in some method ...
    theObservable.register(myHiddenObserver);
}