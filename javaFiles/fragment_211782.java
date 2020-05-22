CheckBox checkbox_auto_billing = (CheckBox)v.findViewById(R.id.checkbox_auto_billing);
    checkbox_auto_billing.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            Intent intent = new Intent(getActivity(), AutoBillingActivity.class);
            startActivity(intent);
        }
    });