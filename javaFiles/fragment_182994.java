public class Ordina{
    public static List<RisorsaWeb> perCriterioUtente(Set<RisorsaWeb> unstorted, Comparator<RisorsaWeb> comparator){
        List<RisorsaWeb> list = new ArrayList<RisorsaWeb>();
        list.addAll(unsorted);
        Collections.sort(list,comparator);
        return list;
    }
}