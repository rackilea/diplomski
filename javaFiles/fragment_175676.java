String foo = validitem(param);
if ( foo != null ) {
    container.putField(key, foo);
} else {
    throw new Exception();
}