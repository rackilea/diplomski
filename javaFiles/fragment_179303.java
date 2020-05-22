List<String> stringArrayList = new ArrayList<>();
int intValue = 5;

Intent i = new Intent(ActivityOne.this, ActivityTwo.class);
i.putExtra("int_key", intValue);
i.putStringArrayListExtra("string_key", stringArrayList);
startActivity(i);