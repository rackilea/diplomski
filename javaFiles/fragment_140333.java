public static void main(String[] args){
    Test t = new Test();
    List<List<Integer>> blah = t.getAllFactors(new int[]{10, 12, 1, 5});
    for(List<Integer> i: blah)
        System.out.println(Arrays.toString(i.toArray(new Integer[i.size()])));
}