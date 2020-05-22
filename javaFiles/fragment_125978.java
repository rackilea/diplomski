public void onClick(View view) {
        num1 = Double.parseDouble(caller.val1.getText().toString());
        num2 = Double.parseDouble(caller.val2.getText().toString());
        res = num1 + num2;
        Toast.makeText(caller, String.valueOf(res), Toast.LENGTH_SHORT).show();
}