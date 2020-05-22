public class HackedGlyphSubstitutionTableReader extends OpenTypeFontTableReader {

    // copy-pasted code ...

    public Map<Integer, List<Integer>> getRawSubstitutionMap() {
        return rawLigatureSubstitutionMap;
    }
}