DeptTask deptTask = new DeptTask(new DeptResponse() {
            @Override
            public void processFinished(List<Department> output) {
                Log.i("Department", "Finished");

                ArrayAdapter<Department> deptAdapter = new ArrayAdapter<Department>(
                        getApplicationContext(),
                        R.layout.spinner,
                        deparments
                );


                deptAdapter.setDropDownViewResource(
                        R.layout.spinner
                );


                spinner.setAdapter(deptAdapter);

                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        Log.i("Selected Item", "I AM INDEED WORKING");
                        filter((Department)spinner.getSelectedItem());

                    }



                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
            }


        });