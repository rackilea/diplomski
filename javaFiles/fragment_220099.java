final Button loginButton = (Button) rootView.findViewById(R.id.connect);
loginButton.setOnClickListener(new OnClickListener() {

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), LoginDisplayActivity.class);
        startActivity(intent);
    }
});