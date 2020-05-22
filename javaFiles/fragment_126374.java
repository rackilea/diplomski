private void populateListView() {
        ArrayAdapter<Patient> adapter = new PatientListAdapter();
        //add the list patients to your adapter
        for(Patient p: patients)
        {
           adapter.add(p);
        }
        ListView patientList = (ListView) findViewById(R.id.listPatientsInER);
        patientList.setAdapter(adapter);

    }