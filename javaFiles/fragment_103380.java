public class YourNewAbstractClass extends LegacyAbstractClass {
    @Override
    public void do(Data someData, BaseInterface interface) {
        CastTheBaseInterface obj = (CastTheBaseInterface) interface;
        doCasted(someData, obj );
    }

    public abstract doCasted(Data someData, CastTheBaseInterface interface)
}