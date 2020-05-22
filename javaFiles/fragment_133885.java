radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

            switch (checkedId) {

                case R.id.radioButtonLondon:
                    tClock.setTimeZone("Europe/London");
                    break;

                case R.id.radioButtonBeijing:
                    tClock.setTimeZone("CST6CDT");
                    break;


                case R.id.radioButtonNewYork:
                    tClock.setTimeZone("America/New_York");
                    break;
            }
            // End switch block

        //}
    }
});