class test {

    public static void main(String[] rawrs) {
        RealEng re = new RealEng();
        RealAct ra = new RealAct();
        MockAct ma = new MockAct();
        ra.apply(re);
        // Remove all code related to Type interface if next line should compile
        ma.apply(re); // compile error here
    }

    static interface Type {
    }

    static interface Real extends Type {
    };

    static interface Mock extends Type {
    };

    static abstract class AbEng<T extends Type> {

        final void func(AbAct<T> act) {
            act.apply(this); // compile error here
        }

    }

    static abstract class AbMes<T extends Type> {

    }

    static abstract class AbAct<T extends Type> {

        abstract void apply(AbEng<T> e);

    }

    static class RealEng extends AbEng<Real> {

    }

    static class RealMes extends AbMes<Real> {

    }

    static class RealAct extends AbAct<Real> {
        @Override
        void apply(AbEng<Real> eng) {
            System.out.println("applied!");
        }
    }

    static class MockAct extends AbAct<Mock> {
        @Override
        void apply(AbEng<Mock> eng) {
            System.out.println("applied!");
        }
    }

}