ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_dropdown_item_1line);

    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
        People p = snapshot.getValue(People.class);

        //just adding id in list use later
        peopleArray.add(String.valueOf(p.id));

        //adding each name to your adapter
        dataAdapter.add(p.name);
    }


    spinner.setAdapter(dataAdapter);
    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            // get pID from peopleArray when item is selected 
            String pId = peopleArray.get(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    });