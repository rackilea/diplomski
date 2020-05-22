ArrayList<Function<Integer, Integer>> fList = new ArrayList<>();
fList.add(i -> i+1);
Function<Integer, Integer> g = new Function<>(){
    final Function<Integer, Integer> fPre = fList.get(fList.size()-1);
    @Override
    public Integer apply(Integer integer){
        if (integer == 1)
            return 42;
        else
            return fPre.apply(integer);
    }
}
fList.add(g);