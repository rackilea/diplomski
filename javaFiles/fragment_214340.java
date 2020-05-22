public class FooBProcessing extends AbstractFooProcessing<FooB>{

    @Override
    public FooB createFooInstance(Cursor cursor) {
        return FooB.from(cursor);
    }

}