minChar.setVisibility(View.INVISIBLE);
if (validatePassword.length()<8 || validatePassword.length()>24){
            minChar.setText("minimum 8 characters, up to 24 characters");
            minChar.setTextColor(Integer.parseInt("#ff0000"));
            minChar.setVisibility(View.VISIBLE);
}