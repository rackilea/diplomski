public String format(){
    if (getRank() < 11) {
        return String.format("%d of %s, ", getRank(), getSuit());
    }
    else {
        Faces face = Faces.values()[getRank() - 11];
        return String.format("%s of %s, ", face, getSuit());
    }
}