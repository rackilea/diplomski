LayoutInflater layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    LinearLayout layout=(LinearLayout)this.findViewById(R.id.parentLayout);

    for (int i = 0 ; i<3; i++){
        Spinner spinner = (Spinner) layoutInflater.inflate(R.layout.spinner, null);
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, array));
        spinner.setId(i);
        spinner.setSelection(i);

        layout.addView(spinner);
    }