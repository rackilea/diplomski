public static void main(String ...args){
    long start = System.currentTimeMillis();
    List<Integer> l1 = new ArrayList<>();
    List<Integer> l2 = new ArrayList<>();

    for(int i = 0 ; i < Integer.MAX_VALUE/10000;i++){
        l1.add(i);
        l2.add(i);
    }

    System.out.println(String.format("Field both arrays in %s seconds",(System.currentTimeMillis()-start)/1000) );
    start = System.currentTimeMillis();
    l1.removeAll(l2);

    System.out.println(String.format("Removed one array from other %s seconds",(System.currentTimeMillis()-start)/1000) );

}