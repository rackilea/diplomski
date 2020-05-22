public class ChildClass extends YourNewAbstractClass {
    @Override
    public void doCasted(Data someData, CastTheBaseInterface casted) {
        casted.exec(someData);
    }
}