new PersistenceDelegate() {
        protected Expression instantiate(Object oldInstance, Encoder out) {
            Locale l = (Locale) oldInstance;
            return new Expression(oldInstance, oldInstance.getClass(),
                    "new", new Object[] { l.getLanguage(), l.getCountry(),
                            l.getVariant() });
        }
    }