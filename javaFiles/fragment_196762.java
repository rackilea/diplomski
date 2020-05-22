{
    Objective obj;
    // ...
    Scoreboard sb = obj.getScoreboard();
    final HashMap<String, Integer> map = new HashMap<>();
    for (String entry : sb.getEntries())
        map.put(entry, obj.getScore(entry).getScore();
    obj.unregister();
    obj = sb.registerNewObjective("foo", "dummy");
    for (final Entry<String, Integer> entry : map.entrySet())
        obj.getScore(entry.getKey()).setScore(entry.getValue());
}