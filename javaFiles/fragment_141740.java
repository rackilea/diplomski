public class EnumTest
{
    public enum Chord
    {
        MAJOR,
        MINOR,
        DIMINISHED,
        BASS,
        BASS2
    }

    public enum Scales
    {
        C("C"),
        CSharp("C#"),
        E("E"),
        F("F"),
        G("G"),
        A("A");

        private final String printName;

        Scales(String printName)
        {
            this.printName = printName;
        }

        public String getPrintName()
        {
            return printName;
        }

        public String toString()
        {
            return printName;
        }

        private static final Map<Chord, List<Scales>> scalesForChord;

        static
        {
            scalesForChord = new HashMap<Chord, List<Scales>>();

            scalesForChord.put(Chord.MAJOR, Arrays.asList(Scales.C, Scales.E, Scales.G));
        }

        public static List<Scales> getScalesForChord(Chord chord)
        {
            return scalesForChord.get(chord);
        }
    }
}