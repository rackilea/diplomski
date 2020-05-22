final GMTDateTransform transform = new GMTDateTransform();
    return new Persister(new Matcher() {
        @Override
        public Transform match(Class cls) throws Exception {
            if (cls == Date.class) return transform;
            return null;
        }
    });