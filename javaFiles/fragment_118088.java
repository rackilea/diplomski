private void testTask(){
  .... all code in the main thread particularly on the requests and responses
  from the services
 //print the response or the result
 //Log.e() makes the message in the android monitor red like an error
 Log.e("Response:", [responseparameter.toString()]);

}

//create the inherited class from the AsyncTask Class
//(you can create within your activity class)
class AsyncTaskRunner extends AsyncTask<String,String,String>{
    @Override 
    public String doInBackground(String ... input){
        testTask(); // call the testTask() method that i have created
        return null; // this override method must return String
    }

} 

//I've created a button for running the task
public void buttonTask(View view){
    AsyncTaskRunner runner = new AsyncTaskRunner();
    runner.execute();

}