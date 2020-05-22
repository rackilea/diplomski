public void afterTextChanged(Editable s) {
        if(s.length() > 0 && s.toString().charAt(s.length()-1) == 'S')
        {
            final String newText = s.toString().substring(0, s.length()-1) + "a"; 
            editText.setText(newText); 
        }
    }