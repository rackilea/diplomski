enum MyEnum {

    ONE(Test.getInstance().one()),
    TWO(Test.getInstance().two());

    public final String val;

    MyEnum(String val) { this.val = val; }
}