`public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioyear2:
                if (checked)
                    MonthsTxtView.setText("24");
                Log.i(TAG, "onRadioButtonClicked: ");
                    break;
            case R.id.radioyear3:
                if (checked)
                    MonthsTxtView.setText("36");
                Log.i(TAG, "onRadioButtonClicked: ");
                    break;
            case R.id.radioyear5:
                if (checked)
                    MonthsTxtView.setText("60");
                Log.i(TAG, "onRadioButtonClicked: ");
                break;
        }
    }
      }`