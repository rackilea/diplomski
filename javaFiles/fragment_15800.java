JSONObject jsonObj = new JSONObject(myJSON);
    peoples = jsonObj.getJSONArray("result");

    ArrayList<Student> personList=new ArrayList<Student>();;
    for (int i = 0; i < peoples.length(); i++) {

       Student student = new Student();            
       JSONObject c = new JSONObject(peoples.getString(i));
       student.setName(c.getString("NAME");
       student.setRollNo(c.getString(TAG_ROLL));

       personList.add(student);
     }