...
// you can create a new Intent for the result
Intent newIntent = new Intent();
newintent.putExtra("edittextvalue",s.toString());
newintent.putExtra("listPosition", position);
setResult(RESULT_OK, newintent);        
finish();
...