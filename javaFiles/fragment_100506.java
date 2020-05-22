adapter.setViewBinder(new SimpleAdapter.ViewBinder() {

        @Override
        public boolean setViewValue(View view, Object data,
                String textRepresentation) {
            // Log.v(TAG, "Binding view: " + view);

            if (view.getId() == R.id.list_image) {
                ((ImageView) view).setContentDescription((CharSequence)) data);
                return true;
            }

            return false;
        }
    });