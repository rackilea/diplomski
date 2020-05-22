Dialog  mutuallyDialog = new Dialog(getActivity());
mutuallyDialog.requestWindowFeature(android.view.Window.FEATURE_NO_TITLE);
mutuallyDialog.setContentView(R.layout.new_couple);
mutuallyDialog.findViewById(R.id.popup_av2).setBackground(someDrawable); 


mutuallyDialog.show();