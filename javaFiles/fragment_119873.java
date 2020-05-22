boolean check3Pieces(Piece p0, Piece p1, Piece p2, String caption) {
    if(p0 == null || p1 == null || p2 == null)
    {
        return false;
    }

    if(p0.getName().equals(p1.getName()) && p0.getName().equals(p2.getName()))
    {
        winner = p0.getName()+ " " + caption;
        return true;
    }
    return false;
}