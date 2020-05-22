Call<Result<List<Meeting>>> call = mClient.createMeeting(meeting.getName(), meeting.getDate_start(), meeting.getDate_ended(), meeting.getLocation(), meeting.getLatitude(), meeting.getLongitude(), meeting.getPoints(), meeting.getMember_ids());
    call.enqueue(new Callback<Result<List<Meeting>>>() {
        @Override
        public void onResponse(Call<Result<List<Meeting>>> call, Response<Result<List<Meeting>>> response) {
            if (response.isSuccessful()) {
                Toast.makeText(getApplicationContext(), "Meeting Dibuat", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(mContext, MainActivity.class);
                mContext.startActivity(i);
                ((Activity) mContext).finish();
            } else {
                Toast.makeText(getApplicationContext(), "Membuat Meeting Gagal", Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), "Response Error: HTTP Code " + String.valueOf(response.code()),
                        Toast.LENGTH_SHORT).show();
                Log.e(TAG + "onResponse", String.valueOf(response.raw().toString()));
            }
        }
        @Override
        public void onFailure(Call<Result<List<Meeting>>> call, Throwable t) {
            Log.e("On Failure", t.getMessage());

        }
    });