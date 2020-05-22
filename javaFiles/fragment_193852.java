List<Result> result= new ArrayList<Result>();
for(ValueList data1: valueListA){
    boolean found = false;
    for (ValueList data2: valueListB){
        Result inter= new Result();
        if(data1.getLine_num==data2.getLine_num){
           inter.setKey(data1.getKey());
           inter.setValue(data1.getValue());
           result.add(inter);
           found = true;
           break;
        }
    }
    if (!found) {
       result.add(...)
    }
}