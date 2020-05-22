int amount = 10; // just making 10 the default if the EditText has an invalid value
try {
    amount = Integer.parseInt(smsamount.getText().toString());
}
catch (NumberFormatException) {}

for (i = 0; i < amount; i++) {