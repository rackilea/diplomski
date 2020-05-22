button3.setOnClickListener(new View.OnClickListener() {

        public void onClick(View v) {

            String text = s1.getSelectedItem().toString();
            list.add(text);
            // To notify adapter after that changes in data 
            adapter.notifyDataSetChanged();
        }
    });