public static class Union {
    public Object o;
    public Union( Object value ) { o = value; }
    public Class<? extends Object> getType() { return o.getClass(); }
    public <T> T value() {
        return (T) o;   // <-- uses type parameter to cast
    }
}

public static void main(String[] args) {
    Union union = new Union( "foo" );

    Class<?> valueType = union.getType();
    if ( valueType.equals( String.class )) {
        String s = union.value();     // <-- the call 
        System.out.println( s );
    }
}