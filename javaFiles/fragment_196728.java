DialogInterface.OnClickListener actionListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
          //goto category list with which as the category
        }
      };

public void categoryDialogShow(final Context context, String[] categoryOptions){
    final AlertDialog actions;

    AlertDialog.Builder categoryAlert = new AlertDialog.Builder(context);
    categoryAlert.setTitle("Choose a Category");

    categoryAlert.setItems(categoryOptions, actionListener);
    categoryAlert.setNegativeButton("Cancel", null);
    actions = categoryAlert.create();


  actions.show();
}