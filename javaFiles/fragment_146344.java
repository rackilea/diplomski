@Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
             String input = s.toString();
            if(input.contains(".") && s.charAt(s.length()-1) != '.'){
                if(input.indexOf(".") + 3 <= input.length()-1){
                    String formatted = input.substring(0, input.indexOf(".") + 3);
                    editReceiver.setText(formatted);
                    editReceiver.setSelection(formatted.length());
                }
            }else if(input.contains(",") && s.charAt(s.length()-1) != ','){
                if(input.indexOf(",") + 3 <= input.length()-1){
                    String formatted = input.substring(0, input.indexOf(",") + 3);
                    editReceiver.setText(formatted);
                    editReceiver.setSelection(formatted.length());
                }
            }
        }