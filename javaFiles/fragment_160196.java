interface VerbPhrase { };

class IntransitiveVerbPhrase implements VerbPhrase {
    Verb verb;
    AdverbPhrase adverb; /* optional */
};

class TransitiveVerbPhrase implements VerbPhrase {
    Verb verb;
    AdverbPhrase adverb; /* optional */
    NounPhrase obj;
};