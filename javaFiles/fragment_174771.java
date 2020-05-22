public static void product(LinkedList<Integer> list) 
{
    Iterator<Integer>productw = list.iterator();
    int result = 1;
    for( int i=0; i<productw.size(); ++i ) {
        result *= productw.get(i) ;
    }
    // result has the answer
}