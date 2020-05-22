public static Engine getScriptEngine(Long userId) {
     String key = "MY_ENGINE" + userId;
     ScriptEngine eng = (ScriptEngine) Cache.get(key);
     if(eng == null) {
        eng = ScriptEngine.create(); 
        Cache.put(key, eng);
     }
     return eng;
}