View rootView = inflater.inflate(R.layout.fragment_main, container, false);

// Find your button in the layout.
Button btnMyButton = (Button) rootView.findViewById(R.id.btnMyButton);

btnMyButton.setOnClickListener(new OnClickListener() {

  @Override
  public void onClick(View v) {
        Intent i = newIntent(getActivity(),NewActivity.class);
        startActivity(i);
  }

});