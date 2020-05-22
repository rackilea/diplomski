List<String> optionList = new ArrayList<>();
    for (DataSnapshot ansattSnapshot : dataSnapshot.getChildren()) {
        final Ansatt ansatt = ansattSnapshot.getValue(Ansatt.class);
        optionList.add(ansatt.getAnsattnavn());
        listansatt.add(ansatt);
    } 

    ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, optionList);
    spinnerControl.setAdapter(adapter);