mDateSetListener = new DatePickerDialog.OnDateSetListener() {
    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        month = month + 1;
        String yearAsString = Integer.toString(year);
        String monthAsString = Integer.toString(month);
        String dayAsString = Integer.toString(day);
        if (day <= 9 & month <= 9) {
            String date = "0" + dayAsString + "-" + "0" + monthAsString + "-" + yearAsString;
            mDisplayDate.setText(date);
        } else if (day <= 9 & month > 9) {
            String date = "0" + dayAsString + "-" + monthAsString + "-" + yearAsString;
            mDisplayDate.setText(date);
        } else if (month <= 9) {
            String date = dayAsString + "-" + "0" + monthAsString + "-" + yearAsString;
            mDisplayDate.setText(date);
        } else {
            String date = dayAsString + "-" + monthAsString + "-" + yearAsString;
            mDisplayDate.setText(date);
        }

        String passDate = mDisplayDate.getText().toString().trim();

        Log.i(TAG, "PassDate = " + passDate);

        Query query = databaseReference.orderByChild("timestamp").equalTo(passDate);
        options = new FirebaseRecyclerOptions.Builder<Records>().setQuery(query, Records.class).build();

        adapter = new FirebaseRecyclerAdapter<Records, RecordsViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull RecordsViewHolder holder, int position, @NonNull Records model) {
                holder.t1.setText(model.getTimestamp());

            }

            @NonNull
            @Override
            public RecordsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.saved_records_view, viewGroup, false);

                return new RecordsViewHolder(view);
            }
        };
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }
};