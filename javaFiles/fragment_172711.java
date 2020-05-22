SharedPreferences sharedPref = getSharedPreferences("MyData", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

 etPresent = findViewById(R.id.etPresent);
    etDetails = findViewById(R.id.etDetails);
    etBenefit = findViewById(R.id.etBenefit);

etPresent.setText(sharedPref.getString("present", ""));
etDetails.setText(sharedPref.getString("details", ""));
etBenefit.setText(sharedPref.getString("benefit", ""));