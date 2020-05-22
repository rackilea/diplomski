interface AsyncInternalWrapper {
    void work(List objsToPublish);
}


@Service
public class AsyncInternalWrapperImpl implements AsyncInternalWrapper {
    @Async
    public void work(List objsToPublish) {
      expensiveWriteOperation(objsToPublish);
    }
}