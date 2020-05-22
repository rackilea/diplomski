class LombokBuilderTest {

    public static class LombokBuilderTestBuilder {
        private List<Object> list;
        private boolean list$set;

        LombokBuilderTestBuilder() {}

        public LombokBuilderTestBuilder list(final List<Object> list) {
            this.list = list;
            list$set = true;
            return this;
        }

        public LombokBuilderTest build() {
            return new LombokBuilderTest((list$set ? list : LombokBuilderTest.$default$list()));
        }

        @Override
        public String toString() {
            return (("LombokBuilderTest.LombokBuilderTestBuilder(list=" + this.list) + ")");
        }
    }

    List<Object> list;

    private static List<Object> $default$list() {
        return new ArrayList<>();
    }

    public static LombokBuilderTestBuilder builder() {
        return new LombokBuilderTestBuilder();
    }

    public LombokBuilderTest() {}

    public LombokBuilderTest(final List<Object> list) {
        this.list = list;
    }

    public static void main(String[] args) {
        List<Object> list = new LombokBuilderTest().list;
        System.out.println(list);
    }
}