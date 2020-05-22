for (String line: lines)
{
    float charSpacing = 0;
    if (line.length() > 1)
    {
        float size = fontSize * pdfFont.getStringWidth(line) / 1000;
        float free = width - size;
        if (free > 0)
        {
            charSpacing = free / (line.length() - 1);
        }
    }
    contentStream.appendRawCommands(String.format("%f Tc\n", charSpacing).replace(',', '.'));

    contentStream.drawString(line);
    contentStream.moveTextPositionByAmount(0, -leading);
}