add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enter1= str1 .getText().toString();
                String enter2= str2 .getText().toString();
                display1.setText(enter1+" "+enter2);
            }
        });