class ExceptionA extends IllegalStateException {
    public ExceptionA(String s) {
        super(s);
    }
}
class ExceptionB extends IllegalStateException {
    public ExceptionB(Throwable cause) {
        super(cause);
    }
}
Rethrowing.translateExceptions(
    Stream.of("foo", "bar", "baz", "", "extra")
        .peek(s -> System.err.println("consuming \""+s+'"'))
        .map(s -> { if(s.isEmpty()) throw new ExceptionA("empty"); return s; }),
    ExceptionA.class, ExceptionB::new)
        .forEach(s -> System.err.println("terminal operation on "+s));