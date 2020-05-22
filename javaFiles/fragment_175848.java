private static final Map<String, Character> codonsMap;
static
{
    codonsMap = new HashMap<String, Character>();
    codonsMap.put("UUU", 'F');
    codonsMap.put("UUC", 'F');
    codonsMap.put("UUA", 'L');
    //and so on for all codons
}

//be sure that length of temp is a multiple of 3 and that every 3 characters correspond to a valid codon
public String translation(String temp)
{
    //Use StringBuilder for adding Characters, it is by far faster than adding chars to a mutable String
    StringBuilder finalreturn = new StringBuilder();
    String codon;       
    for (int i = 0; i < temp.length() - 2; i++) {
        codon = temp.substring(i, i+3);
        finalreturn.append(codonsMap.get(codon));
    }
    return finalreturn.toString();
}