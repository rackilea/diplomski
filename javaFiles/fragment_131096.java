private View.OnClickListener onItemClickListener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
        int position = viewHolder.getAdapterPosition();
        Doctors doctor = list.get(position);
        Intent intent = new Intent(getActivity(), DoctorProfile.class);
        intent.putExtra("id",doctor.getID();
        startActivity(intent);

    }
  };