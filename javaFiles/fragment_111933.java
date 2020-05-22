public interface MyNSNumber extends NSObject {
    public static final _Class CLASS = Rococoa.createClass("NSNumber", _Class.class);

    public interface _Class extends NSClass {
        ID numberWithBool(boolean value);
    }
}