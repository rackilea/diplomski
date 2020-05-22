AbstractAutoCompleteRenderer<String> autoCompleteRenderer = new AbstractAutoCompleteRenderer<String>() {
                    private static final long serialVersionUID = 1L;

                    protected final String getTextValue(final String bean) {
                        String name;
                        // Do you logic to extract the name from the bean
                        ...
                        ...
                        ...

                        return name;
                    }

                    @Override
                    protected final void renderChoice(final String object, final Response response, final String criteria) {
                        response.write(getTextValue(object));
                    }

                };


final AutoCompleteTextField<String> autoComp = new AutoCompleteTextField<String>("item", new PropertyModel(str, "item"),
                        autoCompleteRenderer) {
                    private static final long serialVersionUID = 1L;

                    @Override
                    protected Iterator<String> getChoices(String arg0) {
                        // Your logic
                        ...
                        ...
                        ...

                        return filteredList.iterator();
                    }

                };