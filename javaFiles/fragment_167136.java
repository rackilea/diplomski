List<String> keyList = new ArrayList<>();
keyList.addAll(getDummyProperties().keySet());

final DataView<String> propertiesView = new DataView<String>("properties", new ListDataProvider<>(keyList)) {
        @Override
        protected void populateItem(Item item) {

            String key = item.getModelObject().toString();
            item.add(new Label("property_name", key));
            item.add(new TextField<String>("edit_field", new PropertyModel<String>(getDummyProperties(), key)));
        }
};