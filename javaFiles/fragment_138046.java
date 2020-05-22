JSONObject job=new JSONObject('your json string');
Iterator itr=job.keys();
while(itr.hasNext())
{
int id=Integer.parseInt(itr.next());
JSONArray jar=job.getJSONArray(id);
String firstName=jar.getString(0);
String lastName=jar.getString(1);
}