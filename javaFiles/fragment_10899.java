ResourceBundle resources = ResourceBundle.getBundle("TestResourceBundle", new ResourceBundle.Control() {

                @Override
                public List<String> getFormats(String baseName) {

                    if (baseName == null) {
                        throw new NullPointerException();
                    }

                    return Collections.unmodifiableList(Arrays.asList("java.properties", "java.class"));
                }

            });