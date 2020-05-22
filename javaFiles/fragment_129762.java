private Map<Pattern, Runnable> patterns;
{
    {
        patterns = new LinkedHashMap<Pattern, Runnable>();
        patterns.put(Pattern.compile("\\w+"), new Runnable() { public void run() { System.out.println("word");   } });
        patterns.put(Pattern.compile("\\d+"), new Runnable() { public void run() { System.out.println("number"); } });
    }
}

public void matchAndExecute(String str) {

    Iterator<Entry<Pattern, Runnable>> it = patterns.entrySet().iterator();
    while (it.hasNext()) {
        Entry<Pattern, Runnable> pattern = it.next();
        if (pattern.getKey().matcher(str).matches()) {
            pattern.getValue().run();
        }
    }
}