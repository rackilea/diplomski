LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL); 

        TextView menuText = new TextView(this);
        menuText.setText("People");
        menuText.setId(100);
        menuText.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        layout.addView(menuText);

        for (int i = 0; i < 10; i++) {

            LinearLayout row = new LinearLayout(this);
            row.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));


                Button btnTag = new Button(this);
                btnTag.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
                btnTag.setText( " " + i);
                btnTag.setId(1 + (i));
                row.addView(btnTag);

                btnTag.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        String buttonText = "Unknown Person";
                            Button b = (Button) findViewById(v.getId());
                            buttonText = (String) b.getText();

                        TextView tx = (TextView) findViewById(100);
                        tx.setText(buttonText + " pressed.");
                    }
                });


            ScrollView sc = new ScrollView(this);
            sc.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
            sc.setFillViewport(true);

            sc.addView(row);

            layout.addView(sc);

            setContentView(layout);