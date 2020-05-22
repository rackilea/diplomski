@Override
public void onClick(View v) {
    String name1 = editText1.getText().toString();
    String year2 = editText2.getText().toString();
    String month2 = editText3.getText().toString();
    String day2 = editText4.getText().toString();
    String price2 = editText5.getText().toString();

    if (name1.length() != 0 && year2.length() != 0 && month2.length() != 0 && day2.length() != 0 && price2.length() != 0) {

        // Move parsing code here
        int year1 = Integer.parseInt(year2);
        int month1 = Integer.parseInt(month2);
        int day1 = Integer.parseInt(day2);
        int price1 = Integer.parseInt(price2);
        AddData(name1, year1, month1, day1, price1);

        editText1.setText("");
        editText2.setText("");
        editText3.setText("");
        editText4.setText("");
        editText5.setText("");

        Intent intent = new Intent(Main2Activity.this, MainActivity.class);
        startActivity(intent);

    } else {

        Toast.makeText(Main2Activity.this, "You need to fill everything", Toast.LENGTH_LONG).show();
    }
}