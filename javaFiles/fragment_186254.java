Column<MyObject, String> delete = new Column<MyObject, String>(new ButtonCell()) {

            @Override
            public String getValue(final MyObjectobject object) {
                return "delete";
            }
        };

        delete.setFieldUpdater(new FieldUpdater<MyObject, String>() {

            @Override
            public void update(final int index, final MyObjectobject object, final String value) {

                myActivity.delete(object); // to whatever should happen if button is clicked
            }
        });