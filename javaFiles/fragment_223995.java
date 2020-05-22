CollectionUtils.find(a, new Predicate() {
        @Override
        public boolean evaluate(Object object) {
            return ((Method)object).getMethodName().equals("aaa");
        }
    });