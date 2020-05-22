@State( Scope.Benchmark )
public abstract class TestBase
{
    @Setup
    public void setUp( BenchmarkParamsState state )
    {
        // do something with state.someParam
    }

    @State( Scope.Benchmark )
    public static class BenchmarkParamsState
    {
        String someParam;

        @Setup
        public void setUp( BenchmarkParams params )
        {
            // set someParam based on contents of params
        }
    }
}

@State( Scope.Benchmark )
public class TestImpl extends TestBase
{
    @State( Scope.Thread )
    public static class ThreadState 
    {
        @Setup
        public void setUp( TestImpl state ){}
    }

    @Benchmark
    public void nothing( ThreadState state ){}
}