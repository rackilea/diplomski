addButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String getInput = input.getText().toString();
        list.add(getInput); //add this line
        adapter.addAll(getInput);
        saveData();
        input.setText(""); //clear the value in the edit text
    }
});