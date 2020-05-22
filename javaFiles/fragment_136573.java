public class MyTask extends Task<SomeDataType> {

    @Override
    public SomeDataType call() {

        SomeDataType result = longRunningProcess();
        return result ;
    }
}