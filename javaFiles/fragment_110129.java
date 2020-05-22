private static Function0<BoxedUnit> getBoxedUnitFunction0(Runnable f) {
    return new AbstractFunction0<BoxedUnit>() {

            @Override
            public BoxedUnit apply() {
                f.run();
                return BoxedUnit.UNIT;
            }
        };
}