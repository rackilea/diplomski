private class OnItemClickListener implements View.OnClickListener {
        private int mPosition;

        OnItemClickListener(int position) {
            mPosition = position;
        }

        @Override
        public void onClick(View arg0) {
           Patient p=patientItems.get(mPosition);
String Title=p.getTitle();
Log.d("Title at row"+mPosition,Title);
        }
    }