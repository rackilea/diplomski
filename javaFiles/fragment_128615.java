HashMap<String, String> studentMap = mydb.getAllStudents();
// Converting HashMap values into ArrayList
List<String> array_list = new ArrayList<String>(studentMap.values());
Log.d("array size:,", String.valueOf(array_list.size()));

ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.list_layout, array_list);
//Adding the contacts to the list view.
student = (ListView) findViewById(R.id.listView1);
student.setAdapter(arrayAdapter);
//Setting an onClickListener to process the user's actions
student.setOnItemClickListener(new OnItemClickListener() { 
 @Override 
 public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) { 
  // TODO Auto-generated method stub 
  Log.d("arg2 ", String.valueOf(arg2)); 

  TextView tempTextView = (TextView) arg1;
  String data = tempTetxtView.getText();


  for (Entry<String, String> entry : studentNameAndId.entrySet()) { 
      if (entry.getValue().equals(data)) { 
        int id_To_Search = Integer.valueOf(entry.getKey()); 
        //id_list.get(arg2+1); 
        Bundle dataBundle = new Bundle(); 
        dataBundle.putInt("studentId", id_To_Search); 
        //Create a new intent to open the DisplayContact activity 
        Intent intent = new Intent(getApplicationContext(), com.example.ltss.dyslexia.app.StudentProfilePage.class); 
        intent.putExtras(dataBundle); 
        startActivity(intent); 
       } 
     }
    }
 });