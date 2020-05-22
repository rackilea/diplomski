cb.setConverter(new StringConverter<String>(){
    @Override
    public String toString(String object) {
        if(object != null) {
            String[] valSplit = object.split("[\\(\\)]");
            return valSplit[1];
        } else 
            return null;

    }

    @Override
    public String fromString(String string) {

        List<String> collect = cb.getItems().stream().filter(s -> s.contains(string)).collect(Collectors.toList());
        if(collect.size() == 1)
            return collect.get(0);
        else
            return null;
    }
});

cb.setCellFactory(item -> {
    return new ListCell<String>(){
        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);

            if(item == null || empty)
                setText("");
            else
                setText(item);
        }
    };
});