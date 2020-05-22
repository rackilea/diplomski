enum MyEnum {

    A1, A2, A3;

}

String val = "myVal"; // your input

MyEnum enumVal;
try {
    enumVal = MyEnum(val);
} catch (IllegalArgumentException iae) {
    enumVal = null;
}

switch (enumVal) {

    case A1: 
        doSomething();
        break;

    case A2: 
        doOtherStuff();
        break;

    default: 
        doDefault();
        break;

}