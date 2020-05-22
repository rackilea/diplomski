@RequestMapping(method=RequestMethod.GET,value="/showStudent.do")
@ResponseBody
public String showEnrolledStudent()
{
    //This will get persistence manager for datastore interaction
    PersistenceManager pm=PMF.get().getPersistenceManager();
    //Query for selecting list of student enrolled
    Query query=pm.newQuery(Student.class);
    //Json array holds the json objects.
    JSONArray studentListJson=new JSONArray();
    try
    {
        List<Student> listOfStudent=(List<Student>) query.execute();
        //Loop to create the list of student in json format
        for(Student student:listOfStudent)
        {
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("key", student.getKey().getId());
            jsonObject.put("name", student.getName());
            jsonObject.put("age", student.getAge());
            jsonObject.put("mobile", student.getMobile());
            studentListJson.put(jsonObject);

        }
    }
    catch (Exception e) {
    }
        return studentListJson.toString();
}