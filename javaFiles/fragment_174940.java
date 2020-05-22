taskadd.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            addtask=taskname.getText().toString();
            adddetail=taskdetail.getText().toString();
            adddate= taskdate.getText().toString();
            InsertData();
            Notification();

        }
    });