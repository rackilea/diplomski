Intent intent = new Intent(this, ActivityB);
String[] COUNTRIES = new String[] {
    "Belgium", "France", "Italy", "Germany", "Spain"
};

intent.putExtra("countries", COUNTRIES);
startActivity(intent);