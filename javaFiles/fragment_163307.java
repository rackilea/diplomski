String countries = "Belgium,France,Italy,Germany,Spain";

Intent intent = new Intent(this, ActivityB);

intent.putExtra("countries", countries);
startActivity(intent);