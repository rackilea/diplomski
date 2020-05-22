yourEditText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(String string, int i, int i1, int i2) {}

                @Override
                public void onTextChanged(String string, int i, int i1, int i2) {

                     if(string.contains("Z")){

                        yourEditText.setInputType(InputType.TYPE_CLASS_NUMBER);

                     }
                }

                @Override
                public void afterTextChanged(Editable editable) {}
            });