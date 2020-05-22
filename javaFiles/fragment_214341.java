public class FooAProcessing implements FooProcessing<FooA>{

    @Override
    public FooA createFooInstance(Cursor cursor) {
        return FooA.from(cursor);
    }   
}