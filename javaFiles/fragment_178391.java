bookAppoinmentBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(final View view) {
            MyapptsFragment myaaptsFragment = new MyapptsFragment();
            AppCompatActivity activity = (AppCompatActivity) view.getContext();
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, myaaptsFragment).addToBackStack(null).commit();
           ((MyActivity)getActivity()).changeMenu(R.id.action_settings);

        }
    });