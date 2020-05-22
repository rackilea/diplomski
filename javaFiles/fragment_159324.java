private void showPopup(final View view) {
    DroppyMenuPopup.Builder popup = new DroppyMenuPopup.Builder(context, view);
    popup.addMenuItem(new DroppyMenuItem("Move").setId(R.id.moveButton));
    popup.addMenuItem(new DroppyMenuItem("Edit").setId(R.id.editButton));
    popup.addMenuItem(new DroppyMenuItem("Insert Row Above").setId(R.id.insertRow));
    // Set Callback handler
    popup.setOnClick(new DroppyClickCallbackInterface() {
        @Override
        public void call(View v, int id) {
            switch (id) {
                case R.id.editButton:
                    //code for editButton
                    break;
                case R.id.moveButton:
                    //code for moveButton
                    break;
                case R.id.insertRow:
                    //code for insertRow
                    break;
                default:
            }
        }
    });

    DroppyMenuPopup droppyMenu = popup.build();
    droppyMenu.show();
}