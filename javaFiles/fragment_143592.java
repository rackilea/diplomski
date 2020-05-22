spinnerType = view.findViewById(R.id.spinnerDrinkType);
    //Get the different types of drinks
    Cursor cursorTypes = coctelsOpenHelper.getTypes();

    //Add "All" field to the spinner, for that "all" field is added first to the ArrayList,
    // and later each item of the cursor
    ArrayList<String> spinnerArray = new ArrayList<>();

    spinnerArray.add(getString(R.string.title_all_drinks));
    for(cursorTypes.moveToFirst(); !cursorTypes.isAfterLast(); cursorTypes.moveToNext()) {
        spinnerArray.add(cursorTypes.getString(1));
    }
    ArrayAdapter<String> adapter = new ArrayAdapter<>(
            getContext(), android.R.layout.simple_spinner_item, spinnerArray);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    spinnerType.setAdapter(adapter);


    spinnerType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
    {
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
        {                
            text = spinnerType.getSelectedItem().toString();

            addSelection();
            initializeData();
            initializeAdapter();
        }
)};