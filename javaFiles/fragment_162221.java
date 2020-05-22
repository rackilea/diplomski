@Override
public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);

        BTN=(Button) getView().findViewById(R.id.button_id); 
        // if button is in fragment layout should us getView() instead of activity
        comm=(Communicator)getActivity();
        BTN.setOnClickListener(this);

}