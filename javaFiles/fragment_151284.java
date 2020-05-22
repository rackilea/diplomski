public enum ProgramOfStudy {
    ComputerScience("CS"), AutomotiveComputerScience("ACS"), BusinessInformatics("BI");

    public final String shortCut;

    private static final Map<String, ProgramOfStudy> shortCutMap = Collections.unmodifiableMap(new HashMap<>() {
        {
            Arrays.stream(ProgramOfStudy.values()).forEach(v -> put(v.shortCut, v));
        }
    });

    ProgramOfStudy(String shortCut) {
        this.shortCut = shortCut;
    }

    public static ProgramOfStudy getByShortCut(String shortCut) {
        return shortCutMap.get(shortCut);
    }
}

public static void main(String[] args) {
    System.out.println(ProgramOfStudy.getByShortCut("CS"));
    System.out.println(ProgramOfStudy.getByShortCut("ACS"));
    System.out.println(ProgramOfStudy.getByShortCut("baasda"));
    System.out.println(ProgramOfStudy.getByShortCut("BI"));
}