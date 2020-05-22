DateDialogFragment frag = DateDialogFragment.newInstance(
    this, 
    new AddEventActivity.DateDialogFragmentListener() {

        @Override
        public void updateChangeDate(int year, int month, int day) {
            // TODO Auto-generated method stub

        }
    }, sYear, sMonth, sDay);