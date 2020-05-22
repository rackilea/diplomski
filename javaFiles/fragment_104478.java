public class MusicStateManager {

  private final Preferences prefs;
  public final Mgame game;

  private static final String PREF_NAME ="APP_NAME";   
  private static final String MUSIC_STATE = "musicState";

  public MusicStateManager(Mgame game){
      this.game = game;
      prefs = Gdx.app.getPreferences(PREF_NAME);
      game.menuMusicBool = prefs.getBoolean(MUSIC_STATE, true); // return true when key not found
  }

  public void saveMusicState(boolean musicState) {
    game.menuMusicBool = musicState;
    prefs.putBoolean(MUSIC_STATE, musicState);
    prefs.flush();

    // music state changed and saved, now need to start or stop music
    if(game.menuMusicBool)    // I supposed game having music object reference
         game.music.play();
    else 
         game.music.stop(); 
  }

  public boolean getMusicState() {
     return prefs.getBoolean(MUSIC_STATE);
  }