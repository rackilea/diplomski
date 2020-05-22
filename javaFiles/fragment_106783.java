for (int p = 1; p <= 4; ++p)
{
    stripper.setStartPage(p);
    stripper.setEndPage(p);
    String text = textStripper.getText(pddDocument);
    if (text.contains("@@end"))
        // do stuff
}