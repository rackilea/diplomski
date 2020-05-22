@Override
public int compare(File f1, File f2) {
    return NaturalComparator.compareNatural(collator, 
                                          f1.getName().replaceAll("^(?i)The ", ""), 
                                          f2.getName().replaceAll("^(?i)The ", ""));
}