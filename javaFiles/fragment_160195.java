enum Type {
    Sentence,
    NounPhrase,
    VerbPhrase,
    Conjunction,
    ...
};

interface PartOfSpeech { };

class NonTerminal implements PartOfSpeech {
    Type type;
    List<PartOfSpeech> subparts;
};

class Terminal implements PartOfSpeech {
    String word;
};