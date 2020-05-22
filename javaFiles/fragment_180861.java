@Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        // ...
        // copy from original post
        // ...

        holder.btnCheckIn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("you clicked", "the item at [" + position + "] position");
                guest_id = guest.get(position).guestId;
                new CheckInAsync(holder).execute();
            }
        });

        return vi;
    }

    // Check In Async Task for executing the POST Request
    public final class CheckInAsync extends AsyncTask<Void, Void, Void> {

        private ProgressDialog mProgressDialog;
        private final ViewHolder holder;

        CheckInAsync(ViewHolder holder) {
            this.holder = holder;
        }

        @Override
        protected Void doInBackground(Void... params) {
              // copy from original post
        }

        protected void onPostExecute(Void result) {
            this.mProgressDialog.dismiss();
            this.holder.btnCheckIn.setText(R.string.heavy_check_mark);
            this.holder.btnCheckIn.setBackgroundColor(Color.MAGENTA);
            Toast.makeText(getContext(), "Checked In!", Toast.LENGTH_SHORT)
                    .show();
        }
    }