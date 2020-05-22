//Whenever you update the score call this function
void updateScore(int score){

    SharedPreferences mySharedPref = getSharedPreferences("give Any Name", Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = mySharedPref.edit();
    editor.putInt("score", score);
    editor.apply();  //this function will commit asynchronously

}