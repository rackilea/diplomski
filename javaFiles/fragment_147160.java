@Override
public void onListItemClick(ListView parent, View view, int position, long id) {

    super.onListItemClick(parent, view, position, id);

      Cursor c = ((SimpleCursorAdapter)parent.getAdapter()).getCursor();
      c.moveToPosition(position);

      // get project name here

      String str_projectname= c.getString(c.getColumnIndex("project_name"));

      Intent intent = new intent(this, openactivity.class);

      intent.putExtra("project_name", str_projectname);

      startActivity(intent);


    //What else to add here?

}