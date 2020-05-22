if (str.equalsIgnoreCase("kolam")) {
    //... code
    kolamTracingGames.setKolamLevel(obj.optInt(str));
    //... code                      ^^^^^^^^^^^^^^^
    break;
} else if (str.equalsIgnoreCase("level")) {
    //... code
    learnTracingGames.setLearnGameLevel(obj.optInt(str));
    //... code                          ^^^^^^^^^^^^^^^
    break;
}