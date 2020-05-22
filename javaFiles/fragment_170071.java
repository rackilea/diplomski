public void setTextViewValues (ArrayList<String> vals, TextView text) {
    //Variable to hold all the values
    String output = "";

    for (int i = 0; i < vals.size(); i++) {
        //Append all the values to a string
        output += vals.get(i);
    }

    //Set the textview to the output string
    text.setText(output);
}