if (skuleString.equals("Vel eit alternativ..")) {
    Toast.makeText(MainActivity.this, "Vel eit alternativ...", Toast.LENGTH_SHORT).show();
}
else {
    Intent myIntent = new Intent(MainActivity.this, SecondActivity.class);
    startActivity(myIntent);
}