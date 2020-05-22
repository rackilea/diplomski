final EditText userEditText = (EditText)findViewById(R.id.userEditText);

userEditText.setOnFocusChangeListener(new OnFocusChangeListener() {

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if(!hasFocus){
            Log.i(TAG, "userEditText lost focus");
            if(null == m_requestFocus){
                m_userName = userEditText.getText().toString();
                if(m_userName.length() < 6){
                    m_signUpText.setText("Username should have at least 6 characters");
                    m_requestFocus = userEditText;
                }
                else{
                    checkUserNameExists();
                }
            }
        }
        else{
            if(null != m_requestFocus & m_requestFocus != userEditText){
                v.clearFocus();
                m_requestFocus.requestFocus();
                m_requestFocus = null;
            }
        }
    }
});