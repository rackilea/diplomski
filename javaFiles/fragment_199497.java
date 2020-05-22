EditText editText=(EditText)findViewById(R.id.edit);

String str = "E";  // string you search for

String s=editText.getText().toString();

String [] array= s.split("\");
int index = -1;

for (int i = 0; i < array.length; i++) {
    if (array[i].equals(str)) { // use equals, not ==
         index = i;
         break;
    }
}