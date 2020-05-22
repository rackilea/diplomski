//Whenever you update the score call this function
public int getScore(){

    SharedPreferences mySharedPref = getSharedPreferences("give Any Name", Context.MODE_PRIVATE);
    return mySharedPref.getInt("score", -1); //-1 is the default value that is returned if the value is not set using putInt

}