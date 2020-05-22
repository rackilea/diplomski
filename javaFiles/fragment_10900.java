public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
    final Team team = teams.get(i);
    final String date = textDate1.getText().toString().trim();
    final String time = textTime1.getText().toString().trim();

    if(TextUtils.isEmpty(date)){
        Toast.makeText(RecreateActivity.this,"Please choose a date.",Toast.LENGTH_LONG).show();
        return;
    }

    if(TextUtils.isEmpty(time)){
        Toast.makeText(RecreateActivity.this,"Please choose a time.",Toast.LENGTH_LONG).show();
        return;
    }

}