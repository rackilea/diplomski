public class Solver {

    public static void main(String[] args) {
        System.out.println("Solver");
        Solver solver = new Solver("j=>i", "i=>j", "v=>u", "u=>v", "s=>f",
            "f=>s", "uu=>w", "vv=>w");
        //Set<String> words = solver.determineAllWords("murdir");
        Set<String> words = solver.determineAllWords("gigi");
        words.forEach(System.out::println);
        System.out.println("Done");
    }

    static class Rule {
        String from;
        String to;

        public Rule(String from, String to) {
            this.from = from;
            this.to = to;
        }
    }

    private final Rule[] rules;

    public Solver(String... tofroms) {
        this.rules = new Rule[tofroms.length];
        for (int i = 0; i < rules.length; ++i) {
            String[] tofrom = tofroms[i].split("=>", 2);
            rules[i] = new Rule(tofrom[0], tofrom[1]);
        }
    }

    public Set<String> determineAllWords(String word) {
        Set<String> solutionWords = new TreeSet<String>(); // Could be a field too.
        solutionWords.add(word);
        int ruleIndex = 0;
        int wordIndex = 0;
        solveTryingRules(solutionWords, word, wordIndex, ruleIndex);
        return solutionWords;
    }

    private void solveTryingRules(Set<String> solutionWords,
            String word, int wordIndex, int ruleIndex) {
        if (ruleIndex >= rules.length) {
            return;
        }
        Rule rule = rules[ruleIndex];
        int wordIndexFound = word.indexOf(rule.from, wordIndex);
        if (wordIndexFound == -1) {
            // Next rule:
            solveTryingRules(solutionWords, word, 0, ruleIndex + 1);
        } else {
                // Keep at same rule, 
            // Not applying rule to found word position:
            solveTryingRules(solutionWords, word, wordIndexFound + 1, ruleIndex);

            // Applying rule to found word position:
            String nextWord = word.substring(0, wordIndexFound)
                    + rule.to
                    + word.substring(wordIndexFound + rule.from.length());
            boolean added = solutionWords.add(nextWord);
            if (added) {
                solveTryingRules(solutionWords, nextWord, 0, 0);
            }
        }
    }
}