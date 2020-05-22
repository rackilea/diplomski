public static void main(String[] args) throws IOException {
    List<String> list = Arrays.asList("Änderung", "Aktivierung", "Auszahlung", "Bar");

    Collections.sort(list, createCollator());

    System.out.println(list);
}

private static RuleBasedCollator createCollator() {
    String german = "" +
                    "= '-',''' " +
                    "< A< a< ä< Ä< B,b< C,c< D,d< E,e< F,f< G,g< H,h< I,i< J,j" +
                    "< K,k< L,l< M,m< N,n< O< o< Ö< ö< P,p< Q,q< R,r< S,s< T,t" +
                    "< U< u< Ü< ü< V,v< W,w< X,x< Y,y< Z,z" +
                    "& ss=ß";

    try {
        return new RuleBasedCollator(german);
    } catch (ParseException e) {
        throw new RuntimeException(e);
    }
}