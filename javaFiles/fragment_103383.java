public class ChildClassOne extends YourNewAbstractClass<CastTheBaseInterface> {
    @Override
    public void doCasted(Data someData, CastTheBaseInterface casted) {
        casted.exec(someData);
    }
}

public class ChildClassTwo extends YourNewAbstractClass<AnotherCastTheBaseInterface> {
    @Override
    public void doCasted(Data someData, AnotherCastTheBaseInterfacecasted) {
        casted.doSomeOtherStuff(someData);
    }
}