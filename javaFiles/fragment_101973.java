String[] examples = {
    "88,TRN:2014091900217161 SNDR REF:149IF1007JMO2507 BISCAYNE BLVD STE",
    "88,TRN:2014091900217161 SNDR REF:149IF1007JMO2507"      
};
//                           ┌ look-behind for "SNDR REF:"
//                           |               ┌ anything, reluctantly quantified
//                           |               |   ┌ lookahead for 
//                           |               |   | whitespace or end of input
Pattern p = Pattern.compile("(?<=SNDR\\sREF:).+?(?=\\s|$)");
// iterating examples
for (String s: examples) {
    Matcher m = p.matcher(s);
    // iterating single matches (one per example here)
    while (m.find()) {
        System.out.printf("Found: %s%n", m.group());
    }
}