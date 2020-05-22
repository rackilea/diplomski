public class TripletsComp implements Comparator<Triplets> {
        @Override public int compare(Triplets e1, Triplets e2) {
            if(e1.c > e2.c){
                return 1;
            }else if (e1.c == e2.c){
                return 0;
            }
            else { return -1; }
        }
    }