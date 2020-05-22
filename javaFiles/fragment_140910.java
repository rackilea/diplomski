private int retrieveCoins() {
    TextView balanceShow = findViewById(R.id.balanceShow);
    SharedPreferences data = getSharedPreferences("MySavedData", Context.MODE_PRIVATE);
    myBalance = data.getInt("BALANCE", -1);
    balanceShow.setText("Balance: " + myBalance + "Coin");
    Toast.makeText(this, "Loaded!", Toast.LENGTH_SHORT).show();
}