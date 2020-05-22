public void setTextViewFromList(ArrayList<PickUpPoint> arraylist, TextView textview) {
    //Variable to hold all the values
    String output = "";

    for (int i = 0; i < arraylist.size(); i++) {
        //Append all the values to a string
        output += arraylist.get(i).getShelving();//whatever you want to show here like shelving or cordinalpoint use getCordinalPoint()
        output += "\n";
    }

    //Set the textview to the output string
   textview.setText(output);
}