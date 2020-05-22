button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {



            arrayAdapter.add(counter +" : "+ editText.getText().toString());
            listView.setAdapter(arrayAdapter);

            counter++ ;

            //clear the edit text 
            editText.setText(""); // i don't get the specific method that will do the job ;


        }
    });