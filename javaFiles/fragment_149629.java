public enum Comparison {
    EQ {
        @Override
        public Criterion convert(String propertyName, Object propertyValue) {
            return Restrictions.eq(propertyName, propertyValue);
        }
    },
    LE {
        @Override
        public Criterion convert(String propertyName, Object propertyValue) {
            return Restrictions.le(propertyName, propertyValue);
        }
    },
    LIKE {
        @Override
        public Criterion convert(String propertyName, Object propertyValue) {
            return Restrictions.like(propertyName, propertyValue);
        }
    };

    public abstract Criterion convert(String propertyName, Object propertyValue);
}