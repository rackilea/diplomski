final MyData items[] = new MyData[myUsers.length()];
for (int i = 0; i < MyData.length(); ++i){
  items[i] = new MyData(myUsers.getJSONObject(i).getString("BusinessName"), myUsers.getJSONObject(i).getString("BusinessPhone"));
}
ArrayAdapter<MyData> adapter = new ArrayAdapter<MyData>(PropertyManagement.this, android.R.layout.simple_spinner_item, items );
adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
userSpinner.setAdapter(adapter);