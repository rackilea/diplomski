private void loadSpinner(Spinner spinner, ArrayList<Integer> items) {
    //list for storing the names
    String[] nameList = new String[items.size() + 1];
    //list for storing the ID and keeping it hidden
    //employeeList = new int[list.size()];
    //loop to fill the list

    nameList[0] = "All Employees";
    //employeeList[0] = 0;
    for (int i = 0; i < items.size(); i++) {
        nameList[i + 1] = String.valueOf(i);
    }
    //creating adapter for spinner
    ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, nameList);
    //drop down layout style - list view with radio button
    dataAdapter.setDropDownViewResource(android.R.layout.select_dialog_multichoice);
    //attaching data adapter to spinner
    spinner.setAdapter(dataAdapter);
}