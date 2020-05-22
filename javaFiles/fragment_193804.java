Button b = new Button(Main2Activity.this);
b.setText(((Button)v).getText());
b.setLayoutParams(vv);
top.addView(b);
//try this
b.post(new Runnable() {
            @Override
            public void run() {
                float x = b.getX();
                float y = b.getY();
            }
        });