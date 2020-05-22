final CharSequence[] items;
if (presetItemId == 0) {
    items = new CharSequence[] { "Delete", "Edit" };
} else{
    items = new CharSequence[] { "Delete"};
}
new AlertDialog.Builder(context).setTitle("Meal Item")
    .setItems(items, new DialogInterface.OnClickListener() { //...