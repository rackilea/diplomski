Integer getMax(Set<Integer> set) {

    Integer max = set.iterator().next();   //  First element in the set

    for(Integer integer : set){
        if(integer>max) {
            max=integer;
        }
    }

    return max;

}