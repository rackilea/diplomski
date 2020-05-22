package com.itextpdf.text.pdf;

import com.itextpdf.text.pdf.fonts.otf.FontReadingException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class GsubHelper {
    private Map<Integer, List<Integer>> rawSubstitutionMap;

    public GsubHelper(TrueTypeFont font) {
        // get tables offsets from the font instance
        Map<String, int[]> tables = font.tables;
        if (tables.get("GSUB") != null) {
            HackedGlyphSubstitutionTableReader gsubReader;
            try {
                gsubReader = new HackedGlyphSubstitutionTableReader(
                        font.rf, tables.get("GSUB")[0], glyphToCharacterMap, font.glyphWidthsByIndex);
                gsubReader.read();
            } catch (IOException | FontReadingException e) {
                throw new IllegalStateException(e.getMessage());
            }
            rawSubstitutionMap = gsubReader.getRawSubstitutionMap();
        }
    }

    /** Returns a glyphId substitution map
     */
    public Map<Integer, List<Integer>> getRawSubstitutionMap() {
        return rawSubstitutionMap;
    }
}