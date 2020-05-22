class PF<T>
{
    public void setValue(Parameter<T> parameter, T value) {
    }

    public void setValue(Parameter<T> parameter, Field<T> value) {
    }
}

void test()

    PF<Object> pf2 = null;

    Parameter<Object> p2 = getP2();
    Field<Object> f2 = getF2();

    pf2.setValue(p2,f2);