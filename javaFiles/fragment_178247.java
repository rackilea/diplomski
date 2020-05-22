static Function2<Integer,Integer,Integer> AddIntegers = new Function2<Integer,Integer,Integer>(){
    @Override
    public Integer call (Integer i1,Integer i2){
       return i1 + i2;
    }
};
static Function2<Integer,Integer,Integer> SubtractIntegers = new Function2<Integer,Integer,Integer>(){
    @Override
    public Integer call (Integer i1,Integer i2){
       return i1 - i2;
    }
};