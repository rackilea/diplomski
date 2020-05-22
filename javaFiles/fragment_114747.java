ListView yourListView = new ListView("your-list-view", new PropertyModel(this, "pages")){
            @Override
            protected void populateItem(ListItem item) {
                item.add(new Label("label", item.toString()));
            }
        };