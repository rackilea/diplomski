private void postDelayedWrapped(final int counter, int delay) {
    if (counter <= 0) return;
    mUpdateUI = new Runnable() {
        public void run() {
            mVistaInspectionDate = HousingFragment.getVistaInspectionDate();
            mVistaInspectionDateTextView.setText(mVistaInspectionDate);

            if (mVistaInspectionDate != null) {
                mHandler.removeCallbacks(mUpdateUI); //necessary?
            }
            postDelayedWrapped(counter - 1, 1000);
        }
    };

    mHandler.postDelayed(mUpdateUI, delay);
}