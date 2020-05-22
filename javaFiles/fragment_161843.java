public void onButtonClick()
new GetEmployee() {
    @Override
    protected void myPostExecute(ArrayList<Employee> list,String title) {

        Intent intent = new Intent(getApplicationContext(), EmployeeActivity.class);
        intent.putParcelableArrayListExtra("busClass", list);
        intent.putString("title",title);//this is your title
        startActivity(intent);
    }
}.execute();