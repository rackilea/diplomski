interface Callback<T> {
    void complete(T result);
}

public <T> void spinner(int spinnerId, Class<? extends Enum> enumClass, final Callback<T> callback) {

    final Spinner spinner = (Spinner) getActivity().findViewById(spinnerId);
    ArrayAdapter<Enum> arrayAdapter = new ArrayAdapter<Enum>(
            getActivity(), android.R.layout.simple_spinner_dropdown_item, enumClass.getEnumConstants());
    spinner.setAdapter(arrayAdapter);
    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            T result = (T) spinner.getSelectedItem();
            callback.complete(result);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    });
}

// ....

spinner(R.id.ownerSpinner, CarDetailsAdapter.OwnerType.class, new Callback<CarDetailsAdapter.OwnerType>() {
        @Override
        public void complete(CarDetailsAdapter.OwnerType result) {
            owner_result = result;
        }     
    });