ObjectFilter filter = new ObjectFilter() {
        @Override
        public boolean accept(Object object) {
            return object.getClass().getSimpleName().equals("MyFact");
        }
    };

    for (FactHandle handle : session.getFactHandles(filter)) {
        Object fact = session.getObject(handle);
        // Do something with the fact you just found in working memory.
        // ...
    }