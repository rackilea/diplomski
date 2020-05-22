mDateButton.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            FragmentManager fm = getActivity().getFragmentManager();
            DatePickerFragment dialog = new DatePickerFragment();
            dialog.show(fm, DIALOG_DATE);
        }
    });