public void onTextChanged (CharSequence s, int start, int before, int count) {
    // TODO Auto-generated method stub
    if(s.length() > 0 && s.toString().charAt(s.length()-1) == 'q')
    {
        current_string = s.toString();
        current_string = current_string.substring(0, (current_string.length()-1));
        et.setText(current_string + "a"); //add the a after q is deleted
        }
    }
}