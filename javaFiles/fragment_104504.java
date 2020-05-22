public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    //check request code and result code:
    if (requestCode == 999 && resultCode == RESULT_OK) {
        //get the extras:
        Bundle extras = data.getExtras();
        String name = null;
        if (extras != null) {
            name = extras.getString("Name");
            try {
                Intent people = new Intent(this, MainPeopleActivity2.class);
                people.putExtra("Name", name);
                startActivity(people);
                //this.finish();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
            }
        }
    }
}