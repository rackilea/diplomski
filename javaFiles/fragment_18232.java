private Response method(Supplier<Response> supplier) {
    try{
        return supplier.get();
    } catch (Exception e) {
        codeA;
    } finally {
        codeB;
    }
}