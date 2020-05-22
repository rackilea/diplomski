public class RuleTuple implements Comparable<RuleTuple> {
    String head;
    String[] rhs;
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append(head+":"); 
        for( String t: rhs ) 
           b.append(" "+t); 
        return b.toString();
    }
    public int compareTo(RuleTuple src) {
        int cmp = head.compareTo(src.head);
        if( cmp!=0 )
            return cmp;
        if( rhs.length != src.rhs.length )
            return rhs.length - src.rhs.length;
        for( int i=0; i<rhs.length; i++ ) {
            int diff = rhs[i].compareTo(src.rhs[i]);
            if(diff != 0)
                return diff;
        }
        return 0;
    }
    ...
}