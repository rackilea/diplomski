final EditText text = (EditText) findViewById(com.and.R.id.editText1);

    text.addTextChangedListener(new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            boolean flag = true;
            String eachBlock[] = text.getText().toString().split("-");
            for (int i = 0; i < eachBlock.length; i++) {
                if (eachBlock[i].length() > 4) {
                    flag = false;
                }
            }
            if (flag) {

                text.setOnKeyListener(new OnKeyListener() {

                    @Override
                    public boolean onKey(View v, int keyCode, KeyEvent event) {

                        if (keyCode == KeyEvent.KEYCODE_DEL)
                            keyDel = 1;
                        return false;
                    }
                });

                if (keyDel == 0) {

                    if (((text.getText().length() + 1) % 5) == 0) {

                        if (text.getText().toString().split("-").length <= 3) {
                            text.setText(text.getText() + "-");
                            text.setSelection(text.getText().length());
                        }
                    }
                    a = text.getText().toString();
                } else {
                    a = text.getText().toString();
                    keyDel = 0;
                }

            } else {
                text.setText(a);
            }

        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                int after) {
            // TODO Auto-generated method stub

        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    });