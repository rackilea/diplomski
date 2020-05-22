enum PieceColor {
    Black {
        @Override public String toString() { return "dark";}
    },
    White {
        @Override public String toString() { return "light";}       
    }
}