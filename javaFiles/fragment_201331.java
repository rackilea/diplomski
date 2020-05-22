static KnotStrategy getKnotStrategy(String name) {
    switch(name.toLowerCase()) {
        case "slip":   return new SlipKnot();
        case "granny": return new GrannyKnot();
        case "bowline" return new BowlineKnot();

        default: throw new IllegalArgumentException();
    }
}