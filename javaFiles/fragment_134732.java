public class TestActivity extends Activity {

ListView list;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    list = (ListView) findViewById(R.id.list_item);
    setEMPInfo task = new setEMPInfo().execute();


}
private class setEMPInfo extends AsyncTask<Void, Void, ArrayList<Employee>> {
    @Override
    protected ArrayList<Employee> doInBackground(Void... params) {
        String id = "100A";
        String Fname = "John";
        String Lname = "Smith";

        ArrayList<Employee> employees = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            person = new Employee(id, Fname, Lname);
            employees.add(person);
        }
        return employees;
    }
     @Override
     protected void onPostExecute( ArrayList<Employee>result)

        //print it on a ListView
        list.setAdapter(new YourAdapret(getApplicationContext(), result));

    }
}