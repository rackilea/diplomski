@Override
public void enterTypeInt32(TypeInt32Context ctx) {
    System.out.println("It's a 32-bit integer!");
}

@Override
public void enterTypeInt64(TypeInt64Context ctx) {
    System.out.println("It's a 64-bit integer!");
}

@Override
public void enterTypeFloat(TypeFloatContext ctx) {
    System.out.println("It's a single-precision float!");
}