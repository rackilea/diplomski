public static void print() throws Exception {

    String s = "The mean distance of the Sun from the Earth is approximately 149.6 million kilometers (1 AU), though the distance varies as the Earth moves from perihelion in January to aphelion in July";
    int presize = 7;
    int postsize = 7;

    String term = "Earth";
    String[] flds = s.split("[\\s]+");

    int idx = 0;
    for (idx = 0; idx < flds.length && !flds[idx].equals(term); idx++) 
        ;

    if (idx == flds.length)
        throw new Exception("Term not found");

    int start = idx-presize;
    if (start < 0)
        start = 0;
    int end = idx+postsize;
    if (end >= flds.length)
        end = flds.length-1;
    for (int i = start; i <= end; i++) {
        System.out.print(flds[i] + " ");
    }
}