int i = 0;
for (EditText e : list) {
    if(e.getText().toString().equals("something")) {
        System.out.println("editText" + i + " equals something");
        // do stuff
    }
    i++;
}