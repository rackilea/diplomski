new DataView<T>(id, dataProvider) {

    @Override
    protected void populateItem(Item<T> item) {

        item.add(new AjaxEventBehavior("onclick") {

            @Override
            protected void onEvent(AjaxRequestTarget target) {
                // This will execute when row is clicked
            }

        });

        // Continue populating item here
    }
}