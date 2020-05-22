public void onClick(View v) {
        switch (v.getId()) {
        case R.id.submit:

            Code.title = editTextTitle.getText().toString().trim();
            Code.description = editTextDesc.getText().toString().trim();

            Code.diff = Code.DueDate.getTimeInMillis()
                    - Code.AssignDate.getTimeInMillis();
            Code.days = Code.diff / (24 * 60 * 60 * 1000);
            Code.strDays = String.valueOf(Code.days);

            Date assignDate = new Date(Code.AssignDate.getTimeInMillis());
            Date dueDate = new Date(Code.DueDate.getTimeInMillis());

            if (Code.DueDate.getTimeInMillis() <= Code.AssignDate.getTimeInMillis()){
                AlertDialog.Builder myDialogBattery = new AlertDialog.Builder(
                        Assignment_Create.this);
                myDialogBattery.setTitle("How to use Less Battery");
                myDialogBattery.setMessage("hahahahahaha");
                myDialogBattery.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface arg0, int arg1) {
                            }
                        });
                myDialogBattery.show();
            }else
            {
                if (isEdit) {
                    this.dataManipulator = new DataManipulator(this);
                    this.dataManipulator.update(updateId);
                    this.dataManipulator.close();
                } else {
                    this.dataManipulator = new DataManipulator(this);
                    this.dataManipulator.insert(Code.title, Code.description,
                            Code.strDays);
                    this.dataManipulator.close();
                }

                Toast.makeText(getApplicationContext(),
                        "Details are saved successfully", Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),
                        "Assignment Created Succesfully", Toast.LENGTH_LONG).show();
                Assignment_Create.this.finish();
            }
            break;
        }
    }