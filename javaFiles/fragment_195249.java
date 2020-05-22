Float foo;
float conditionalResult;

if ( tm == null ) {
    conditionalResult = 0F;
} else {
    conditionalResult = tm.get(key).floatValue(); //this throws the NPE
}
foo = Float.valueOf(conditionalResult);