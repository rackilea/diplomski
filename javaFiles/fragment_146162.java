CharSequence text= (CharSequence) parent.getItemAtPosition(pos);
//This is where you change the text to show
text = "You " + text;
Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
//If you want to update the listview
Cheatcodes[pos] = text;