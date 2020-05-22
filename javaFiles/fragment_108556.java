public class lvl{
public Context mcontext;

public lvl(Context context){
    this.mcontext = context;

}
public int getLevelPlayer(){

    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(mcontext);
    int level = preferences.getInt("player_level", 0); //level is the current level of the playe
    return level;
}