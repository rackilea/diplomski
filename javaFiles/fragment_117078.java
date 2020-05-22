inputScoreWe.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                   if(s.length() > 0){
                      inputScoreYou.setText(162 - Integer.parseInt(inputScoreYou.getText().toString())+"");
                   }

                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });