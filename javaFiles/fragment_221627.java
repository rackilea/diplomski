listView.setOnItemClickListener(new OnItemClickListener() {
@Override
public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
Log.d(TAG, "clicked on item: " + position);
Intent intent = new Intent(List.this, Edit.class);

Person p = new Person();
Cursor cursor = (Cursor) customAdapter.getItem(position);
p.name = cursor.getString(cursor.getColumnIndex("person_name"));
p.surname = cursor.getString(cursor.getColumnIndex("person_surname"));
p.enterDate = cursor.getString(cursor.getColumnIndex("person_enterdate"));
p.enterTime = cursor.getString(cursor.getColumnIndex("person_entertime"));
p.exitDate = cursor.getString(cursor.getColumnIndex("person_exitdate"));
p.exitTime = cursor.getString(cursor.getColumnIndex("person_exittime"));

//get the rest of the attributes
intent.putExtra("id", position);  
intent.putExtra("name", p.name);
intent.putExtra("surname", p.surname);
//put the rest of the data here
startActivity(intent);
}
});