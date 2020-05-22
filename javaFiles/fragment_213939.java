Preferences prefs = Gdx.app.getPreferences("My Preferences");
    prefs.putString("name", "Donald Duck");
    String name = prefs.getString("name", "No name stored");

    prefs.putBoolean("soundOn", true);
    prefs.putInteger("highscore", 10);