listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView textView = view.findViewById(R.id.textViewId);
        EditText editText = view.findViewById(R.id.editTextId);
        String selectedBet = textView.getText().toString();
    }
});