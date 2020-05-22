import java.util.ResourceBundle;

    ResourceBundle dummyResourceBundle = new ResourceBundle() {
        @Override
        protected Object handleGetObject(String key) {
            return "fake_translated_value";
        }

        @Override
        public Enumeration<String> getKeys() {
            return Collections.emptyEnumeration();
        }
    };

    // Example usage
    when(request.getResourceBundle(any(Locale.class))).thenReturn(dummyResourceBundle)