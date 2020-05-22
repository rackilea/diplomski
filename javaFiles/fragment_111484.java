JSONArray myListsAll= new JSONArray(jsonStr);
int test_id = Integer.MIN_VALUE;
for(int i=0;i<myListsAll.length();i++)
{
    JSONObject obj= (JSONObject) myListsAll.get(i);
    int curTestId = obj.getInt("TestID");
    if (test_id < curTestId)
    {
       History= obj.getString("History");
       Science= obj.getString("Science");
       Maths= obj.getString("Maths");
       English= obj.getString("English");
       test_id = curTestId;
    }
}

System.out.print("Maximum Test Id for this student :" + test_id );