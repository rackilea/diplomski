File file = ....
FileOutputStream fOut = new FileOutputStream(file);
OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
editText = (EditText) findViewById(R.id.editText);
String res = editText.getText().toString();        
myOutWriter.write(res);
myOutWriter.close();
fOut.close();