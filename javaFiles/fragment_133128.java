public void addField(View v) {
    if(parentLayout.getChildCount() < maxCourses) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.field, null);
        Spinner spinner = rowView.findViewById(R.id.first_spinner);
        ArrayAdapter<String> arrayAdapter = getAnAdapterForThatSpinner();
        spinner.setAdapter(arrayAdapter)
        //add new row before add field button
        parentLayout.addView(rowView);
    } else {
        Toast.makeText(this, "No more than " + maxCourses + " courses\ncan be taken per semester", Toast.LENGTH_SHORT).show();
    }
}