//Valida conteúdo do email
char_Email.setOnFocusChangeListener(new View.OnFocusChangeListener(){
    @Override
    public void onFocusChange(View v, boolean hasFocus){
        if(!hasFocus){
            email = char_Email.getText().toString();
            boolean validEmail = isEmailValid(email);
            if(!validEmail) {
                 // Do something, maybe show a Toast
            }
        }
    }
    private boolean isEmailValid(String email){
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
});