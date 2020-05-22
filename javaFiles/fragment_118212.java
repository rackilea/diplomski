FloatArray levels = new FloatArray();
    levels.add(5993);
    levels.add(5995);

    ...

    Preferences p = Gdx.app.getPreferences("SETTINGS");

    Json json = new Json();

    String levelsJson = json.toJson(FloatArray.class, levels);

    p.putString("levels", levelsJson);