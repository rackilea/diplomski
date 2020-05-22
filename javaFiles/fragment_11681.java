adapter = new ArrayAdapter<String>(Bookings.this, android.R.layout.simple_list_item_1, booking_info_minor) {
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = super.getView(position, convertView, parent);

        String confirm = ApproveArray.get(position);

        switch (confirm) {
            case "Approved":
                view.setBackgroundResource(R.color.approved);
                break;
            case "Not Approved":
                view.setBackgroundResource(R.color.not_approved);
                break;
            case "Canceled":
                view.setBackgroundResource(R.color.canceled);
                break;
        }

        return view;
    }
};