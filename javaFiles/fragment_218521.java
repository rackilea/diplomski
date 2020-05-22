dropdown1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
            text1 = dropdown1.getSelectedItem().toString();

            if (text1.equals("red")) {
                dropdown1.setBackgroundColor(Color.parseColor("#ff0000"));
                adapter.notifyDataSetChanged();
            } else if (text1.equals("green")) {
                dropdown1.setBackgroundColor(Color.parseColor("#00ff00"));
                adapter.notifyDataSetChanged();
            } else if (text1.equals("blue")) {
                dropdown1.setBackgroundColor(Color.parseColor("#0000ff"));
                adapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parentView) {

        }

    });