public class FooAProcessing extends AbstractFooProcessing<FooA>{

    @Override
    public FooA createFooInstance(Cursor cursor) {
        return FooA.from(cursor);
    }

}