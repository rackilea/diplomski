button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ExampleActivity.class);
                //There is no limit for number of Extras you want to pass to activity
                intent.putExtra("buttonNumber", 1);
                startActivity(intent);
            }
        });