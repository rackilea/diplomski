public static int samletBeløb(ArrayList<Bruger> brugere) 
{
    int samletBeløb = 0;
    for (int i = 0; i < brugere.size(); i++) {
        samletBeløb += brugere.get(i).getBeløbGivet();
    }

    return samletBeløb;
}