protected String doInBackground(Boolean... params) {
// other code
return "status"
} 
@Override
protected void onPostExecute(String result) {
super.onPostExecute(result);
    Toast.makeText(getApplicationContext(),"My status is"+result,Toast.LENGTH_SHORT).show(); 
}