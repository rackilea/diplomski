buttonOne.create("Label", new AbstractFunction0<BoxedUnit>() {
    @Override
    public BoxedUnit apply() {
        Controller.doSomething()
        return BoxedUnit.UNIT;
    }
});