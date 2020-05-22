ArrayList<Person> list = new ArrayList<Person>();

public void onButtonClick() {
    Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
    intent.putParcelableArrayListExtra("personObject", list);
    startActivity(intent);
}