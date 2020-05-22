// copy of rijtje
List<Stijgen> sorted = new ArrayList<Stijgen>(rijtje);
// sort copy by comparator
// JAVA8: Collections.sort(sorted, (a, b) -> a.getNummer() - b.getNummer()); 
Collections.sort(sorted, new Comparator<Stijgen>() {
@Override
public int compare(Stijgen a, Stijgen b) {
return a.getNummer() - b.getNummer();
}
});
// check if rijtje is sorted
System.out.println(rijtje.equals(sorted));