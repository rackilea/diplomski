boolean containsParagemWithName(ArrayList<Paragem> paragems, String pickName) {
    for (Paragem p : paragems) {
        if (p.nomeParagem.equals(pickName)) {
            return true;
        }
    }
    return false;
}