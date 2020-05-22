@Override
 public void onViewCreated(View view, @Nullable Bundle  savedInstanceState) {
super.onViewCreated(view, savedInstanceState);

  getDialog().getWindow().setSoftInputMode(
        WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
  final Button cancelDialog = (Button)view.findViewById(R.id.cancelDialogButton);
  View.OnClickListener listenerDialog = new View.OnClickListener() {
    @Override
    public void onClick(View v) {

    }
};
cancelDialog.setOnClickListener( listenerDialog );
}}