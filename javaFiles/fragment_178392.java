myImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((MyActivity)getActivity()).changeMenu(R.id.action_settings);

            }
        });