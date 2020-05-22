autocomplete.addTextChangedListener(new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if(s.length() > 0){
                text = s.toString();
                if(map_clients.containsKey(text)){
                    Toast.makeText(context, "He's here", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context, "He's not here", Toast.LENGTH_SHORT).show();
                }
            }else{

            }
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    });