static boolean isMark(char ch)
{
    int type = Character.getType(ch);
    return type == Character.NON_SPACING_MARK ||
           type == Character.ENCLOSING_MARK ||
           type == Character.COMBINING_SPACING_MARK;
}