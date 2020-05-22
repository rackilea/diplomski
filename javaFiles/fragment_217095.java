System.out.println(gsonOptFact.toJson(new BasicObjectOptional(true)));
// {"someKey":"someValue","someNumber":42,"mayBeNull":null}

System.out.println(gsonOptFact.toJson(new ComplexObjectOptional(true)));
// {"theTitle":"Complex Object","stringArray":["Hello","World"],"theObject":{"someKey":"someValue","someNumber":42,"mayBeNull":null}}

// Now read back in:
String basic = "{\"someKey\":\"someValue\",\"someNumber\":42,\"mayBeNull\":null}";
String complex = "{\"theTitle\":\"Complex Object\",\"stringArray\":[\"Hello\",\"world\"],\"theObject\":{\"someKey\":\"someValue\",\"someNumber\":42,\"mayBeNull\":null}}";
String complexMissing = "{\"theTitle\":\"Complex Object\",\"theObject\":{\"someKey\":\"someValue\",\"mayBeNull\":null}}";

BasicObjectOptional boo = gsonOptFact.fromJson(basic, BasicObjectOptional.class);
System.out.println(boo);
// someKey = Optional[someValue], someNumber = Optional[42], mayBeNull = Optional.empty

ComplexObjectOptional coo = gsonOptFact.fromJson(complex, ComplexObjectOptional.class);
System.out.println(coo);
// theTitle = Optional[Complex Object], stringArray = Optional[[Optional[Hello], Optional[world]]], theObject = (Optional[someKey = Optional[someValue], someNumber = Optional[42], mayBeNull = Optional.empty])

ComplexObjectOptional coom = gsonOptFact.fromJson(complexMissing, ComplexObjectOptional.class);
System.out.println(coom);
// theTitle = Optional[Complex Object], stringArray = null, theObject = (Optional[someKey = Optional[someValue], someNumber = null, mayBeNull = Optional.empty])