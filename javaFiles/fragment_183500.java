holder.app_pa_approve.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            appointment.setApprovedStatus(1);

            holder.approved_status.setTextColor(Color.GREEN);
            holder.approved_status.setText("Approved");
            holder.app_pa_approve.setImageResource(R.mipmap.approvedicon);
            notifyDataSetChanged();
            mOnClickListenr.aprove_appointment(appointment, position);
        }
    });