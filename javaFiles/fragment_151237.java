public static void main(String[] args){
    Collection<Integer> a=new ArrayList<>();
    Collection<Integer> b=new ArrayList<>();

    initialise(a);
    initialise(b);
    testRetain(a,b);
}

public static void initialise(Collection<Integer> collection){
    Random rnd=new Random();


    for(int i=0;i<1000;i++){
        collection.add(rnd.nextInt());
    }
}

public static void testRetain(Collection<Integer> collection1, Collection<Integer> collection2){
    collection1.removeAll(collection2);
}