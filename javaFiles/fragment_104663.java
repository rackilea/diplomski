public class ListMaker<T> { // no guarantee about the generics, didn't have a compiler here.

    private List<?> newList;

    // CTOR: initialize internal state.
    private ListMaker( List<T> list ){
         newList = new ArrayList<T>();
         newList.addAll(list);
    }

    // Factory method: Create ListMaker
    public static <T> ListMaker<T> makeFrom(List<T> list){
        ListMaker lm = new ListMaker( list );
        return lm;   
    }

    // apply filter
    public ListMaker<T> filter(Filter<T> filter){
        newList = filter.apply(newList); // <- interface? Just making something up
        return this;
    }

    // apply mapper
    public ListMaker<T> map(Mapper<N,T> map){
        newList = map.apply(newList); // <- interface? Just making something up
        return this;
    }

    // terminator to retrieve the result
    public List<T> toList(){
        return newList;
    }
}