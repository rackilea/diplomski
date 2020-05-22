RelativeLayout rl = (RelativeLayout) findViewById(R.id.layout);
        int id = 0;

        for (int i = (int) 'a'; i <= (int) 'z'; i++) {
            Button button = new Button(this);
            char letter = (char) i;
            String letterOnButton = Character.toString(letter);
            button.setText(letterOnButton);
            button.setId(i);
            LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT);
            lp.addRule(RelativeLayout.BELOW, id);
            rl.addView(button, lp);
            id = i;
        }