// use our additional glyph list for Unicode mapping
unicode = font.toUnicode(code, glyphList);

// when there is no Unicode mapping available, Acrobat simply coerces the character code
// into Unicode, so we do the same. Subclasses of PDFStreamEngine don't necessarily want
// this, which is why we leave it until this point in PDFTextStreamEngine.
if (unicode == null)
{
    if (font instanceof PDSimpleFont)
    {
        char c = (char) code;
        unicode = new String(new char[] { c });
    }
    else
    {
        // Acrobat doesn't seem to coerce composite font's character codes, instead it
        // skips them. See the "allah2.pdf" TestTextStripper file.
        return;
    }
}