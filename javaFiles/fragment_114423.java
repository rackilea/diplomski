checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

      @Override
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
           if (isChecked) {
               ArrayList<String> toothNumber = new ArrayList<>();
               toothNumber.add("1");
               toothNumber.add("2");
               toothNumber.add("3");
               toothNumber.add("4");
               toothNumber.add("5");
               ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, toothNumber);
               spinnerToothNumber.setAdapter(stringArrayAdapter);
            }
          }
        }
    );

    checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

          @Override
          public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
           if (isChecked) {
                ArrayList<String> toothNumber = new ArrayList<>();
                toothNumber.add("1");
                toothNumber.add("2");
                toothNumber.add("3");
                toothNumber.add("4");
                toothNumber.add("5");
                toothNumber.add("6");
                toothNumber.add("7");
                toothNumber.add("8");
                toothNumber.add("9");
                toothNumber.add("10");
                ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, toothNumber);
                  spinnerToothNumber.setAdapter(stringArrayAdapter);
                                                }
                                            }
                                        }
    );