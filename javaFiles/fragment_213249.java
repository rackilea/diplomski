private static void calculateSum(List<BillsBean> billList) {
    Map<String,Double> sumMap=new HashMap<>();
    for(BillsBean bean:billList)
        if(sumMap.containsKey(bean.getMonthYear()))
            sumMap.put(bean.getMonthYear(), bean.getBill()+sumMap.get(bean.getMonthYear()));
        else
            sumMap.put(bean.getMonthYear(),bean.getBill());
    Iterator iter = sumMap.keySet().iterator();
    while(iter.hasNext()){
        String key = iter.next().toString();
        System.out.println("Year: "+key+" Bill: "+sumMap.get(key));
    }
 }