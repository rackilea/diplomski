class TimeComparatorTipo0 implements Comparator<DataImportedTipo0> {
@Override
public int compare(DataImportedTipo0 a, DataImportedTipo0 b) {
    String Time1 = a.ora, Time2 = b.ora;

    int cmp = Time1.compareTo(Time2);
    if (cmp == 0) {
       // avoid expensive operations.
       Long VolTot1 = Long.parseLong(a.volume_totale);
       Long VolTot2 = Long.parseLong(b.volume_totale);
       cmp = VolTot1.compareTo(VolTot2);
    }
    return cmp;