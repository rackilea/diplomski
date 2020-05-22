@Deprecated
static interface SearchBy {
}
static class Domain1SearchBy implements SearchBy {
}

static interface Api10 {
    void some(SearchBy a);
}
static interface Api11 extends Api10 {
    void some(Domain1SearchBy b);
}

static class Api10Impl implements Api10 {
    @Deprecated
    public void some(SearchBy a) {
        System.out.println("some searchby");
    }
}
static class Api11Impl extends Api10Impl implements Api11 {
    public void some(Domain1SearchBy b) {
        System.out.println("some domain1");
    }
}

public static void main(String[] args) {

    //with api 1.0
    Api10 api10 = new Api10Impl();
    api10.some(new SearchBy() {});
    api10.some(new Domain1SearchBy());

    //with api 1.1
    Api11 api11 = new Api11Impl();
    api11.some(new SearchBy() {});
    api11.some(new Domain1SearchBy());

}