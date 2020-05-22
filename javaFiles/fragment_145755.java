@RequestMapping("/sampleJqueryTable")
public Object sampleJqueryTable(HttpServletRequest request,
        HttpServletResponse response) throws IOException
{


    return "sampleJqueryTable";
    //return new Json("OK",studentList2,studentList2.size());

}



    @RequestMapping(value = "/sampleJqueryTables/list")
@ResponseBody
public JsonResult sampleJqueryList(HttpServletRequest request,
        HttpServletResponse response)
{

    HashMap<String, Object> JSONROOT = new HashMap<String, Object>();
    List<FinalAbendData> studentList2 = null;

    try
    {         
    studentList2 = new ArrayList<FinalAbendData>();
    // Add data to Student list
    studentList2.add(new FinalAbendData("Haripriya","Haripriya", "Haripriya", "IT", "xyz@xyz.com"));
    studentList2.add(new FinalAbendData("Haripriya","Haripriya", "Dinesh", "ECE", "xyz@gmail.com"));
    studentList2.add(new FinalAbendData("Haripriya","Haripriya", "Prabhu", "MECH", "abc@gmail.com"));
    studentList2.add(new FinalAbendData("Haripriya","Haripriya", "Badru", "ECE", "efg@gmail.com"));
    studentList2.add(new FinalAbendData("Haripriya","Haripriya", "Lahir nisha", "CSC", "xyz@gmail.com"));
    studentList2.add(new FinalAbendData("Haripriya","Haripriya", "Nilafar nisha", "CSC", "123@gmail.com"));
    studentList2.add(new FinalAbendData("Haripriya","Haripriya", "Jamil", "ECE", "789@gmail.com"));
    studentList2.add(new FinalAbendData("Haripriya","Haripriya", "Mahes", "ECE", "123@gmail.com"));
    studentList2.add(new FinalAbendData("Haripriya","Haripriya", "Lourde", "IT", "xyz@gmail.com"));



    System.out.println(new JsonJtableResponse().ok(studentList2).toString());

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    response.setContentType("application/json");

    JSONROOT.put("Result", "OK");
    JSONROOT.put("Records", studentList2);

    // Convert Java Object to Json
    String jsonArray = gson.toJson(JSONROOT);
    System.out.println(jsonArray);

    return new Json("OK",studentList2,studentList2.size());
    //return new JsonJtableResponse().ok(studentList2);
    //return jsonArray;
    }
    catch(Exception ex){
        // Don't forget to send Error message to jtable
    }

    return new Json("OK",studentList2,studentList2.size());
}