hideKeyboard();

if (hideKeyboard()) {
     ShowProgressDialog(getResources().getString(R.string.saving_design));
     Toast.makeText(getActivity().getApplicationContext(), "Saving design", Toast.LENGTH_LONG).show();
     new SaveTemplateTask().execute();
}