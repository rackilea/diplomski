@Override
public void onClick(View v) {
    String guess = et_guess.getText().toString().toLowerCase();
    if(guess.equals(currentWord)) {
        dictionary.remove(guess);
    }
    ...
}