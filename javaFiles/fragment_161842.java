abstract class GetEmployee{
// your declaration
String title; //my return string

@Override
protected ArrayList<Employee> doInBackground(String... params){
 ArrayList<Employee> emp = new ArrayList<Employee>();
 String title;

 try {

     //get employee details from table using JSoup
     //get employee table title using JSoup

      empObj = new Emp(...);
      bus.add(empObj);
      title="myTitle" //fetch some title value here...2
      return emp;
     } catch (IOException e) {
       e.printStackTrace(); 
     } 
 return emp;

}


@Override
protected void onPostExecute(ArrayList<Employee> list) {
 myPostExecute(list,title);
}

public abstract void myPostExecute(ArrayList<Employee> emp,String title);

}