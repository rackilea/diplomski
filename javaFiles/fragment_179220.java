Intent intent = new Intent(MainActivity.this, FirstActivity.class);
intent.putExtra("number", numberOfTrue);
startActivityForResult(intent,1);

Intent output = new Intent();
output.putExtra("number", numberOfTrue);
setResult(Activity.RESULT_OK, output);
finish();