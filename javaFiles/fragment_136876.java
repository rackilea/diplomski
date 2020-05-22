public void tenp(View view1) {

        EditText e = (EditText) findViewById(R.id.amount);
        if (!e.getText().toString().equals("")) {
            double amount = Double.parseDouble(e.getText().toString());
            double res = (amount / 100.0f) * 10;
            Toast.makeText(getApplicationContext(), "" + res, Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(), "Amount cannot be empty", Toast.LENGTH_SHORT).show();

        }

    }