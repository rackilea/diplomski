protected void onPostExecute(List<Address> addresses) {
      if(addresses==null || addresses.size()==0){
    Toast.makeText(getBaseContext(), "No Location found", Toast.LENGTH_SHORT).show();
return; // ADD RETURN HERE
// Your code will go beyond toast and NPE
 }
...