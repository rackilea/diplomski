protected void onPostExecute(Void result) {
// Put the list of todos into the list view
ArrayAdapter<String> adapter = new ArrayAdapter<String>(ToDoListActivity.this,
        R.layout.todo_row);
for (ParseObject todo : todos) {
    adapter.add((String) todo.get("DataI"));
    adapter.add((String) todo.get("DataO"));
    adapter.add((String) todo.get("DataRSSI"));
    adapter.add((String) todo.get("DataSSID"));
    adapter.add((String) todo.get("DataTIME"));
    adapter.add((String) todo.get("DataRESTRICTED"));
}
setListAdapter(adapter);
ToDoListActivity.this.progressDialog.dismiss();
/* REMOVE BELOW LINES */
//TextView empty = (TextView) findViewById(android.R.id.empty);
//empty.setVisibility(View.VISIBLE);
//TextView empty2 = (TextView) findViewById(android.R.id.empty2);
//empty2.setVisibility(View.VISIBLE);