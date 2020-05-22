String musicalNote = "\uD834\uDD1E" // UTF-16
paint.setTypeface(Typeface.DEFAULT); // default font
if (paint.hasGlyph(musicalNote)) {
    // font has glyph
} else {
    // font does not have glyph
}