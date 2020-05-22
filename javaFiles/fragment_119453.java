public class PatternService {
    AtomicReference<List<Pattern>> patterns = new AtomicReference<>(Collections.emptyList());

    public List<Pattern> getPatterns() {
        return patterns.get();
    }

    public synchronized void addPattern(Pattern p) {
        List<Pattern> newPatterns = new LinkedList<>(patterns.get());
        newPatterns.add(p);
        patterns.set(Collections.unmodifiableList(newPatterns)); // or ImmutableList
    }

    // other mutators
}


public class Checker {
    @Autowired PatternService patternService;

    public boolean check(String param) {
        for(Pattern p: patternService.getPatterns())
            if(p.matcher(param).matches())
                return true;

        return false;
    }
}