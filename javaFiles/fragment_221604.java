interface BaseClassFactory {
    BaseClass create(String firstname, String lastname);
}
class DelegatorContext {
    public static BaseClassFactory active;
}