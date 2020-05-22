public class Collatz {


public static void main(String[] args) {

    List<Long> length = new ArrayList<Long>();

    Map<Long,Long> dict = new HashMap<Long,Long>();

    for(int i = 13; i < 1000000; i++){
            length.add(collat(i, 0,dict));

    }
}

public static long collat(long x, long c, Map<Long,Long> dict){


    if(dict.containsKey(x))
    {
        return dict.get(x);
    }

    if(x == 1){
        dict.put(x, c);
        return c;
    }

    else
    {
        if(x % 2 == 0){
            dict.put(x, collat(x/2, c + 1,dict));
            return dict.get(x);
            }else{
                dict.put(x,collat((3 * x) + 1, c + 1,dict));
                return dict.get(x);
            }
        }
    }

}