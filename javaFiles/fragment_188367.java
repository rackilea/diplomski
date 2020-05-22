// try this
 autoCompleteText.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View arg1, int position, long arg3) {
                String str = (String) adapterView.getItemAtPosition(position);
                autoCompleteText.setText(str);
            }
        });