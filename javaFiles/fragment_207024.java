String s = EnteredAmount.getText().toString();
if(s.isEmpty()){
    Toast.makeText(MainActivity.this, "you must enter a value to converted",
                   Toast.LENGTH_SHORT).show();
}else if(containsChar(s)){
    Toast.makeText(MainActivity.this, "can't contain chars",
                   Toast.LENGTH_SHORT).show();
}else{
   // do operation here
}