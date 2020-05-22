public class FooBProcessing implements FooProcessing<FooB>{

    @Override
    public FooB createFooInstance(Cursor cursor) {
        return FooB.from(cursor);
    }
}