public void SetupQuantitySpinner(String[] quantity) {
Spinner spnr;
spnr = (Spinner)view.findViewById(R.id.spinner_quantity);
ArrayAdapter<String> adapter = new ArrayAdapter<String>(
        getActivity(),
        R.layout.custom_spinner,
        R.id.text_main_seen,
        quantity);
spnr.setAdapter(adapter);
spnr.setSelection(0);
String productQuantity = quantity[spnr.getSelectedItemPosition()];
System.out.println(productQuantity);
}