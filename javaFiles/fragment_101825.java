@Override
public int compareTo(DrugClass o) {
    boolean hasParam = drugName.contains("param");
    boolean oHasParam = o.drugName.contains("param");

    if(hasParam) {
        return oHasParam ? o.drugName.compareTo(drugName) : 1;
    }
    return oHasParam ? -1 : drugName.compareTo(o.drugName);
}