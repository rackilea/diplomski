import java.util.ArrayList;
import java.util.List;


public class TupleArrayList<A,B> extends ArrayList<Tuple<A,B>> {

    /**
     * An ArrayList for tuples that can generate a List of tuples' elements from a specific position within each tuple
     */
    private static final long serialVersionUID = -6931669375802967253L;

    public List<A> GetAValues(){
        ArrayList<A> aArr = new ArrayList<A>(this.size());
        for(Tuple<A,B> tuple : this){
            aArr.add(tuple.aValue);
        }
        return aArr;
    }

    public List<B> GetBValues(){
        ArrayList<B> bArr = new ArrayList<B>(this.size());
        for(Tuple<A,B> tuple : this){
            bArr.add(tuple.bValue);
        }
        return bArr;
    }

}