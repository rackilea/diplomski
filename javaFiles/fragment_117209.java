private static ArrayList<String> AmountOfSequences = new ArrayList<String>(12870);

public static Boolean compare(String Sequence) {
    Boolean NotUnique = true;
    NotUnique = AmountOfSequences.contains(Sequence);
    if (NotUnique == false) {
        AmountOfSequences.add(Sequence);
        System.out.println(AmountOfSequences);
    }

    return (NotUnique);
}