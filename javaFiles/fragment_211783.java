checkbox_auto_billing.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getActivity(), AutoBillingActivity.class);
             startActivity(intent);
        }
    });