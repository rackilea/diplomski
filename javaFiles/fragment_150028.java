interface Alphabet {
    String characters();
}

enum KnownAlphabet implements Alphabet {
    ENG("abc...z"),
    UA("абв...я");

    private final String characters;

    KnownAlphabet(String characters) {
        this.characters = characters;
    }

    @Override
    public String characters() {
        return characters;
    }
}

class Structure {
    public Structure(Alphabet alphabet) {
        String characters = alphabet.characters();
        // do whatever you were doing with the characters before
    }
}