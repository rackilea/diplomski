holder.addfavoruite.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

                ischeckd=true;
                holder.addfavoruite.setVisibility(View.GONE);
                holder.removefavoruite.setVisibility(View.VISIBLE);

                AppPreference.setButtonCLicked(activity, ture);

        }
    });