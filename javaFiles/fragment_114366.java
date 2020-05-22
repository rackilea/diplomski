userText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = userText.getText().toString();
                Intent toNewScreen = new Intent(this, NewScreenActivity.class);

            }
        });