public class MoleculeParser {
    private static final Pattern PATTERN = Pattern.compile ("([A-Z][a-z]?)(\\d*)");

    public static List<Term> parseMolecule (String molecule) {
        List<Term> terms = new ArrayList<> ();

        Matcher matcher = PATTERN.matcher (molecule);
        while (matcher.find()) {
            String element = matcher.group(1);
            String group2 = matcher.group(2);
            if (!group2.isEmpty ()) {
                int atoms = Integer.parseInt (matcher.group(2));
                terms.add(new Term(element, atoms));
            }
            else {
                terms.add(new Term(element));
            }
        }

        return terms;
    }

    public static void main (String[] args) {
        String str = "CH3CH2CH2CH2CH2CH3";
        System.out.println (parseMolecule (str));

        str = "C12H22O11 ";
        System.out.println (parseMolecule (str));

        str = "SiCl4";
        System.out.println (parseMolecule (str));
    }    
}


public class Term {
    public Term (String element) {
        this(element, 1);
    }

    public Term (String element, int atoms) {
        _element = element;
        _atoms = atoms;
    }

    @Override
    public String toString () {
        return _element + (_atoms != 1 ? _atoms : "") ;
    }

    private String _element;
    private int _atoms;
}