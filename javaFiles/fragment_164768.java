if (id == com.app.twelveimams.R.id.homebutton) {
    Log.e("kiran", "clear top from introu");
    Intent intent = new Intent(getApplicationContext(), MainActivity.class);

    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);

    startActivity(intent);
    finish(); // Call once you redirect to another activity